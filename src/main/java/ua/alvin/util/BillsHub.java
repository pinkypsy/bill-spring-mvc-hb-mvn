package ua.alvin.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.FixedBillTable;
import ua.alvin.entity.ResultBillTable;
import ua.alvin.entity.TariffsTable;
import ua.alvin.service.TableService;

import java.util.Date;
import java.util.List;

//!!!instantly delete when realize how to save in multiple entities fields by one form:form save button!!!
//then add those entities as modelAttributes
@Component
@Scope("prototype")
public class BillsHub {

    private TariffsTable tariffsTable;
    private CountedBillTable countedBillTable;
    private FixedBillTable fixedBillTable;
    private ResultBillTable resultBillTable;

    private  TableService resultBillTableService;
    private  TableService countedBillTableService;
  /*  private  TableService fixedBillTableService;
    private  TableService tariffsTableService;*/


    @Autowired
    public BillsHub(@Qualifier(value = "countedBillTableService") TableService countedBillTableService,
                    @Qualifier(value = "resultBillTableService") TableService resultBillTableService/*,
                    @Qualifier(value = "fixedBillTableService") TableService fixedBillTableService,
                    @Qualifier(value = "tariffsTableService") TableService tariffsTableService*/
    ) {
        this.resultBillTableService = resultBillTableService;
        this.countedBillTableService = countedBillTableService;
      /*  this.tariffsTableService = tariffsTableService;
        this.fixedBillTableService = fixedBillTableService;*/

        System.out.println("BillsHub CONSTRUCTOR resultBillTableService " + resultBillTableService);
    }

    /*
    If used electricity in current month is bigger than electricityTariffDelimiter,
    then electricity tariff for remains is greater.

    I.e. if difference on electricity between previous and current month is 99 kVt,
    then electricityTariff = 90.
    If difference is 150 kVt, then:
    for 100 kVt: electricityTariff = 90
    and for the remaining 50 kVt: electricityTariff = 168.
     */
    @Value("${electricityTariffDelimiter}")
    private short electricityTariffDelimiter;

    //tariff values
//    @Pattern(regexp = "\\d+\\.\\d*", message = "Use decimal numbers and point as the separator")
    @Value("${coldWaterTariff}")
    private double coldWaterTariff;

    @Value("${hotWaterTariff}")
    private double hotWaterTariff;

    @Value("${sewageTariff}")
    private double sewageTariff;

    @Value("${electricityBeforeDelimiterTariff}")
    private double electricityBeforeDelimiterTariff;

    @Value("${electricityAfterDelimiterTariff}")
    private double electricityAfterDelimiterTariff;

    @Value("${gasSupplyTariff}")
    private double gasSupplyTariff;

    //counted bill values

    private int hotWater;

    private int coldWater;

    private int electricity;

    private int gasSupply;

    //fixed price values

    private int houseHeatingPrice;

    @Value("${rentServicePrice}")
    private int rentServicePrice;

    @Value("${garbageRemovalPrice}")
    private double garbageRemovalPrice;

    private Date billFillingDate;

    public ResultBillTable initializeAndReturnResultBillTable(List<TableService> tableServices) throws Exception {
        resultBillTable = new ResultBillTable();



        countedBillTableService = tableServices.get(0);
//        fixedBillTableService = tableServices.get(1);
//        tariffsTableService = tableServices.get(2);
        resultBillTableService = tableServices.get(3);

        System.out.println("countedBillTableService in initialize Count " + countedBillTableService);
//        System.out.println("fixedBillTableService in initialize Count " + fixedBillTableSer
        System.out.println("resultBillTableService in initialize Count " + resultBillTableService);
//        this.resultBillTableService = tableService;

        if (    /*isCountedTableValid() &&*/
                initializeAndSaveCountedBillTable() &&
                        initializeAndSaveFixedBillTable() &&
                        initializeAndSaveTariffsTable()) {

            setResultBill();

           /* resultBillTable.setCountedBillTable(countedBillTable);
            resultBillTable.setTariffsTable(tariffsTable);
            resultBillTable.setFixedBillTable(fixedBillTable);*/
//            resultBillTable.setIndicationDate(LocalTime.now());
            System.out.println(countedBillTable);
            System.out.println(fixedBillTable);
            System.out.println(tariffsTable);
            System.out.println(resultBillTable);

            resultBillTable.setCountedBillTable(countedBillTable);
            resultBillTable.setFixedBillTable(fixedBillTable);
            resultBillTable.setTariffsTable(tariffsTable);

            return resultBillTable;

        } else throw new Exception("null exception");
    }

//    @Override
//    public String toString() {
//        return "BillsHub{" +
//                "electricity=" + electricity +
//                '}';
//    }
//    private boolean isCountedTableValid() {
//
//    }


    private boolean initializeAndSaveCountedBillTable() throws Exception {
        countedBillTable = new CountedBillTable();

        countedBillTable.setColdWater(coldWater);
        countedBillTable.setElectricity(electricity);
        //add other values

        System.out.println("countedBillTable in initialize Count " + countedBillTable);

//        countedBillTableService.save(countedBillTable);

        /* tableService.save(countedBillTable);*///save is needed here for previous Data Base row invocation

        return true;

    }

    private boolean initializeAndSaveTariffsTable() throws Exception {

        tariffsTable = new TariffsTable();

        tariffsTable.setColdWaterTariff((int) Math.floor(coldWaterTariff * 100));
        tariffsTable.setElectricityBeforeDelimiterTariff((int) Math.floor(electricityBeforeDelimiterTariff * 100));
        tariffsTable.setElectricityAfterDelimiterTariff((int) Math.floor(electricityAfterDelimiterTariff * 100));
        //add other values
//        resultBillTable.setTariffsTable(tariffsTable);

//        tariffsTableService.save(tariffsTable);
        return true;
    }

    private boolean initializeAndSaveFixedBillTable() throws Exception {

        fixedBillTable = new FixedBillTable();

        fixedBillTable.setGarbageRemovalPrice((int) Math.floor(garbageRemovalPrice * 100));
        //add other values
//        resultBillTable.setFixedBillTable(fixedBillTable);

//        fixedBillTableService.save(fixedBillTable);
        return true;
    }


    private void setResultBill() {

        setCountedValues();


        resultBillTable.setGarbageRemoval(fixedBillTable.getGarbageRemovalPrice());

        resultBillTable.setTotalToPay(computeTotalToPay());
        resultBillTable.setFillingDate(new Date());

    }

    private double computeTotalToPay() {
        return resultBillTable.getColdWater() + resultBillTable.getHotWater() +
                resultBillTable.getElectricity() + resultBillTable.getGarbageRemoval() +
                resultBillTable.getGasSupply() + resultBillTable.getHouseHeating() +
                resultBillTable.getRentService() + resultBillTable.getSewage();
    }

    private void setCountedValues() {

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

    private double computeColdWaterPrice(CountedBillTable previousMonthBill) {
        System.out.println("countedBillTable " + countedBillTable);
        System.out.println("previousMonthBill " + previousMonthBill);

        return (countedBillTable.getColdWater() - previousMonthBill.getColdWater()) *
                tariffsTable.getColdWaterTariff();

    }

    private double computeHotWaterPrice(CountedBillTable previousMonthBill) {

        return (countedBillTable.getHotWater() - previousMonthBill.getHotWater()) *
                tariffsTable.getHotWaterTariff();

    }

    private double computeGasSupplyPrice(CountedBillTable previousMonthBill) {

        return (countedBillTable.getGasSupply() - previousMonthBill.getGasSupply()) *
                tariffsTable.getGasSupplyTariff();

    }

    private double computeSewagePrice(CountedBillTable previousMonthBill) {

        return (countedBillTable.getColdWater() + countedBillTable.getHotWater()) *
                tariffsTable.getSewageTariff();

    }

    private double computeElectricityPrice(CountedBillTable previousMonthBill) {

        double resultPrice = 0;


        int electricityValue = countedBillTable.getElectricity() - previousMonthBill.getElectricity();

        System.out.println("electricityValue " + electricityValue);

        if (electricityValue <= electricityTariffDelimiter) {
            System.out.println("electricityValue <= 100");
            System.out.println("getElectricityBefore100Tariff " + tariffsTable.getElectricityBeforeDelimiterTariff());
            resultPrice = electricityValue * tariffsTable.getElectricityBeforeDelimiterTariff();
        } else /*if (electricityValue > electricityTariffDelimiter)*/ {
            System.out.println("electricityValue > 100");
            System.out.println("getElectricityAfter100Tariff " + getElectricityAfterDelimiterTariff());
            double priceBeforeDelimiter = (electricityValue - Math.abs(electricityTariffDelimiter - electricityValue))
                    * tariffsTable.getElectricityBeforeDelimiterTariff(); // 130 - (100-130)
            System.out.println("priceBeforeDelimiter " + priceBeforeDelimiter);

            double priceAfterDelimiter = Math.abs(electricityTariffDelimiter - electricityValue)
                    * tariffsTable.getElectricityAfterDelimiterTariff();

            System.out.println("priceAfterDelimiter " + priceAfterDelimiter);


            resultPrice = priceBeforeDelimiter + priceAfterDelimiter;
            System.out.println("resultPrice " + resultPrice);
        }
        return resultPrice;
    }


    public double getColdWaterTariff() {
        return coldWaterTariff;
    }

    public void setColdWaterTariff(double coldWaterTariff) {
        this.coldWaterTariff = coldWaterTariff;
    }

    public double getHotWaterTariff() {
        return hotWaterTariff;
    }

    public void setHotWaterTariff(double hotWaterTariff) {
        this.hotWaterTariff = hotWaterTariff;
    }

    public double getSewageTariff() {
        return sewageTariff;
    }

    public void setSewageTariff(double sewageTariff) {
        this.sewageTariff = sewageTariff;
    }

    public double getElectricityBeforeDelimiterTariff() {
        return electricityBeforeDelimiterTariff;
    }

    public void setElectricityBeforeDelimiterTariff(double electricityBeforeDelimiterTariff) {
        this.electricityBeforeDelimiterTariff = electricityBeforeDelimiterTariff;
    }

    public double getElectricityAfterDelimiterTariff() {
        return electricityAfterDelimiterTariff;
    }

    public void setElectricityAfterDelimiterTariff(double electricityAfterDelimiterTariff) {
        this.electricityAfterDelimiterTariff = electricityAfterDelimiterTariff;
    }

    public double getGasSupplyTariff() {
        return gasSupplyTariff;
    }

    public void setGasSupplyTariff(double gasSupplyTariff) {
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

    public double getGarbageRemovalPrice() {
        return garbageRemovalPrice;
    }

    public void setGarbageRemovalPrice(double garbageRemovalPrice) {
        this.garbageRemovalPrice = garbageRemovalPrice;
    }

    public Date getBillFillingDate() {
        return billFillingDate;
    }

    public void setBillFillingDate(Date billFillingDate) {
        this.billFillingDate = billFillingDate;
    }

    public short getElectricityTariffDelimiter() {
        return electricityTariffDelimiter;
    }

    public void setElectricityTariffDelimiter(short electricityTariffDelimiter) {
        this.electricityTariffDelimiter = electricityTariffDelimiter;
    }
}
