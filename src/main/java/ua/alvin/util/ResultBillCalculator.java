package ua.alvin.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.FixedBillTable;
import ua.alvin.entity.ResultBillTable;
import ua.alvin.entity.TariffsTable;
import ua.alvin.service.TableService;

import java.util.Date;

@Component
public class ResultBillCalculator {

    private final TableService countedBillTableService;

    private TariffsTable tariffsTable;
    private CountedBillTable countedBillTable;
    private FixedBillTable fixedBillTable;
    private ResultBillTable resultBillTable;

    @Autowired
    public ResultBillCalculator(@Qualifier(value = "countedBillTableService") TableService countedBillTableService) {
        this.countedBillTableService = countedBillTableService;
        System.out.println("countedBillTableService in Calculator " + countedBillTableService);
    }

    private void initializeTables() {
        tariffsTable = resultBillTable.getTariffsTable();
        fixedBillTable = resultBillTable.getFixedBillTable();
        countedBillTable = resultBillTable.getCountedBillTable();
    }


    public ResultBillTable calculateAndReturnResultBillTable(ResultBillTable resultBillTable) {
        this.resultBillTable = resultBillTable;

        initializeTables();

        setAllCountedValues();

        resultBillTable.setGarbageRemoval(fixedBillTable.getGarbageRemovalPrice());

        resultBillTable.setTotalToPay(computeTotalToPay());

        resultBillTable.setIndicationDate(new Date());


        return resultBillTable;

    }

    private double computeTotalToPay() {
        return resultBillTable.getColdWater() + resultBillTable.getHotWater() +
                resultBillTable.getElectricity() + resultBillTable.getGarbageRemoval() +
                resultBillTable.getGasSupply() + resultBillTable.getHouseHeating() +
                resultBillTable.getRentService() + resultBillTable.getSewage();
    }

    private void setAllCountedValues() {

        CountedBillTable previousMonthBill =
                (CountedBillTable) countedBillTableService.getBillByID(countedBillTableService.getLastInsertedID()/* - 1*/);
//        System.out.println(previousMonthBill.getElectricity());
        if (previousMonthBill == null) {
            // if it is FIRST bill in the DataBase
            previousMonthBill = new CountedBillTable();
        }

        resultBillTable.setColdWater(computeColdWaterPrice(previousMonthBill));

        resultBillTable.setElectricity(computeElectricityPrice(previousMonthBill));


    }

    private int computeColdWaterPrice(CountedBillTable previousMonthBill) {
        System.out.println("countedBillTable " + resultBillTable.getCountedBillTable());
        System.out.println("previousMonthBill " + previousMonthBill);

        return (countedBillTable.getColdWater() - previousMonthBill.getColdWater()) *
                tariffsTable.getColdWaterTariff();

    }

    private int computeHotWaterPrice(CountedBillTable previousMonthBill) {

        return (countedBillTable.getHotWater() - previousMonthBill.getHotWater()) *
                tariffsTable.getHotWaterTariff();

    }

    private int computeGasSupplyPrice(CountedBillTable previousMonthBill) {

        return (countedBillTable.getGasSupply() - previousMonthBill.getGasSupply()) *
                tariffsTable.getGasSupplyTariff();

    }

    private int computeSewagePrice(CountedBillTable previousMonthBill) {

        return (countedBillTable.getColdWater() + countedBillTable.getHotWater()) *
                tariffsTable.getSewageTariff();

    }

    private int computeElectricityPrice(CountedBillTable previousMonthBill) {

        int resultPrice = 0;


        int electricityValue = resultBillTable.getCountedBillTable().getElectricity() - previousMonthBill.getElectricity();

        System.out.println("electricityValue " + electricityValue);

        if (electricityValue <= tariffsTable.getElectricityTariffDelimiter()) {
            System.out.println("electricityValue <= 100");
            System.out.println("getElectricityBefore100Tariff " + tariffsTable.getElectricityBeforeDelimiterTariff());
            resultPrice = electricityValue * tariffsTable.getElectricityBeforeDelimiterTariff();
        } else /*if (electricityValue > electricityTariffDelimiter)*/ {
            System.out.println("electricityValue > 100");
            System.out.println("getElectricityAfter100Tariff " + tariffsTable.getElectricityAfterDelimiterTariff());
            int priceBeforeDelimiter = (electricityValue -
                    Math.abs(tariffsTable.getElectricityTariffDelimiter() - electricityValue))
                    * tariffsTable.getElectricityBeforeDelimiterTariff(); // 130 - (100-130)
            System.out.println("priceBeforeDelimiter " + priceBeforeDelimiter);

            int priceAfterDelimiter = Math.abs(tariffsTable.getElectricityTariffDelimiter() - electricityValue)
                    * tariffsTable.getElectricityAfterDelimiterTariff();

            System.out.println("priceAfterDelimiter " + priceAfterDelimiter);


            resultPrice = priceBeforeDelimiter + priceAfterDelimiter;
            System.out.println("resultPrice " + resultPrice);
        }
        return resultPrice;
    }

}
