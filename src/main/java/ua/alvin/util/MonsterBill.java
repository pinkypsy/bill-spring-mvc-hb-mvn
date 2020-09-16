package ua.alvin.util;

import org.springframework.stereotype.Controller;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.FixedBillTable;
import ua.alvin.entity.ResultBillTable;
import ua.alvin.entity.TariffsTable;
import ua.alvin.service.TableService;

import java.util.Date;

//!!!instantly delete when realize how to save in multiple entities fields by one form:form save button!!!
//then add those entities as modelAttributes
@Controller
public class MonsterBill {

    TableService tableService;

    private CountedBillTable countedBillTable;
    private FixedBillTable fixedBillTable;
    private TariffsTable tariffsTable;
    private ResultBillTable resultBillTable;

    //tariff values
    private int coldWaterTariff;

    private int hotWaterTariff;

    private int sewageTariff;

    private int electricityBefore100Tariff;

    private int electricityAfter100Tariff;

    private int gasSupplyTariff;

    //counted bill values

    private int hotWater;

    private int coldWater;

    private int sewage;

    private int electricity;

    private int gasSupply;

    //fixed price values

    private int houseHeatingPrice;

    private int rentServicePrice;

    private int garbageRemovalPrice;

    private Date billFillingDate;

    public ResultBillTable initializeAndReturnResultBillTable(TableService tableService) throws Exception {
        resultBillTable = new ResultBillTable();

        this.tableService = tableService;

        if (initializeAndSaveCountedBillTable() &&
                initializeAndSaveFixedBillTable() &&
                initializeAndSaveTariffsTable()) {

            setResultBill();

            resultBillTable.setCountedBillTable(countedBillTable);
            resultBillTable.setTariffsTable(tariffsTable);
            resultBillTable.setFixedBillTable(fixedBillTable);
//            resultBillTable.setIndicationDate(LocalTime.now());

            return resultBillTable;

        } else throw new Exception("null exception");
    }


    private boolean initializeAndSaveCountedBillTable() throws Exception {
        countedBillTable = new CountedBillTable();

        countedBillTable.setColdWater(coldWater);
        countedBillTable.setElectricity(electricity);
        //add other values
        System.out.println(tableService);

       /* tableService.save(countedBillTable);*///save is needed here for previous Data Base row invocation

        return true;

    }

    private boolean initializeAndSaveTariffsTable() throws Exception {

        tariffsTable = new TariffsTable();
        tariffsTable.setColdWaterTariff(coldWaterTariff);
        tariffsTable.setElectricityBefore100Tariff(electricityBefore100Tariff);
        tariffsTable.setElectricityAfter100Tariff(electricityAfter100Tariff);
        //add other values
        resultBillTable.setTariffsTable(tariffsTable);
        return true;
    }

    private boolean initializeAndSaveFixedBillTable() throws Exception {

        fixedBillTable = new FixedBillTable();

        fixedBillTable.setGarbageRemovalPrice(garbageRemovalPrice);
        //add other values
        resultBillTable.setFixedBillTable(fixedBillTable);
        return true;
    }


    private void setResultBill() {

        setCountedValues();

        resultBillTable.setGarbageRemoval(garbageRemovalPrice);

    }

    private void setCountedValues() {

        CountedBillTable previousMonthBill = tableService.getPreviousCountedBill();

        resultBillTable.setColdWater(computeColdWaterPrice(previousMonthBill));

        resultBillTable.setElectricity(computeElectricityPrice(previousMonthBill));


    }

    private int computeColdWaterPrice(CountedBillTable previousMonthBill) {
        System.out.println(countedBillTable);
        System.out.println(previousMonthBill);

        return (countedBillTable.getColdWater() - previousMonthBill.getColdWater()) *
                resultBillTable.getTariffsTable().getColdWaterTariff();

    }

    private int computeHotWaterPrice(CountedBillTable previousMonthBill) {

        return (countedBillTable.getHotWater() - previousMonthBill.getHotWater()) *
                resultBillTable.getTariffsTable().getHotWaterTariff();

    }

    private int computeGasSupplyPrice(CountedBillTable previousMonthBill) {

        return (countedBillTable.getGasSupply() - previousMonthBill.getGasSupply()) *
                resultBillTable.getTariffsTable().getGasSupplyTariff();

    }

    private int computeSewagePrice(CountedBillTable previousMonthBill) {

        return (countedBillTable.getColdWater() + countedBillTable.getHotWater()) *
                resultBillTable.getTariffsTable().getSewageTariff();

    }

    private int computeElectricityPrice(CountedBillTable previousMonthBill) {

        int resultPrice = 0;

        int electricityValue = countedBillTable.getElectricity() - previousMonthBill.getElectricity();

        System.out.println("electricityValue " + electricityValue);

        if (electricityValue <= 100) {
            System.out.println("electricityValue <= 100");
            System.out.println("getElectricityBefore100Tariff " + electricityBefore100Tariff);
            resultPrice = electricityValue * tariffsTable.getElectricityBefore100Tariff();
        } else /*if (electricityValue > 100)*/ {
            System.out.println("electricityValue > 100");
            System.out.println("getElectricityAfter100Tariff " + electricityAfter100Tariff);
            int priceBefore100 = (electricityValue - Math.abs(100 - electricityValue))
                    * tariffsTable.getElectricityBefore100Tariff(); // 130 - (100-130)

            int priceAfter100 = Math.abs(100 - electricityValue)
                    * tariffsTable.getElectricityAfter100Tariff();

            resultPrice = priceBefore100 + priceAfter100;
        }
        return resultPrice;
    }


    public int getColdWaterTariff() {
        return coldWaterTariff;
    }

    public void setColdWaterTariff(int coldWaterTariff) {
        this.coldWaterTariff = coldWaterTariff;
    }

    public int getHotWaterTariff() {
        return hotWaterTariff;
    }

    public void setHotWaterTariff(int hotWaterTariff) {
        this.hotWaterTariff = hotWaterTariff;
    }

    public int getSewageTariff() {
        return sewageTariff;
    }

    public void setSewageTariff(int sewageTariff) {
        this.sewageTariff = sewageTariff;
    }

    public int getElectricityBefore100Tariff() {
        return electricityBefore100Tariff;
    }

    public void setElectricityBefore100Tariff(int electricityBefore100Tariff) {
        this.electricityBefore100Tariff = electricityBefore100Tariff;
    }

    public int getElectricityAfter100Tariff() {
        return electricityAfter100Tariff;
    }

    public void setElectricityAfter100Tariff(int electricityAfter100Tariff) {
        this.electricityAfter100Tariff = electricityAfter100Tariff;
    }

    public int getGasSupplyTariff() {
        return gasSupplyTariff;
    }

    public void setGasSupplyTariff(int gasSupplyTariff) {
        this.gasSupplyTariff = gasSupplyTariff;
    }

    public int getHotWater() {
        return hotWater;
    }

    public void setHotWater(int hotWater) {
        this.hotWater = hotWater;
    }

    public int getColdWater() {
        return coldWater;
    }

    public void setColdWater(int coldWater) {
        this.coldWater = coldWater;
    }

    public int getSewage() {
        return sewage;
    }

    public void setSewage(int sewage) {
        this.sewage = sewage;
    }

    public int getElectricity() {
        return electricity;
    }

    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }

    public int getGasSupply() {
        return gasSupply;
    }

    public void setGasSupply(int gasSupply) {
        this.gasSupply = gasSupply;
    }

    public int getHouseHeatingPrice() {
        return houseHeatingPrice;
    }

    public void setHouseHeatingPrice(int houseHeatingPrice) {
        this.houseHeatingPrice = houseHeatingPrice;
    }

    public int getRentServicePrice() {
        return rentServicePrice;
    }

    public void setRentServicePrice(int rentServicePrice) {
        this.rentServicePrice = rentServicePrice;
    }

    public int getGarbageRemovalPrice() {
        return garbageRemovalPrice;
    }

    public void setGarbageRemovalPrice(int garbageRemovalPrice) {
        this.garbageRemovalPrice = garbageRemovalPrice;
    }

    public Date getBillFillingDate() {
        return billFillingDate;
    }

    public void setBillFillingDate(Date billFillingDate) {
        this.billFillingDate = billFillingDate;
    }

}
