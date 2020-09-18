package ua.alvin.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.FixedBillTable;
import ua.alvin.entity.ResultBillTable;
import ua.alvin.entity.TariffsTable;
import ua.alvin.service.TableService;

import java.util.Date;

//!!!instantly delete when realize how to save in multiple entities fields by one form:form save button!!!
//then add those entities as modelAttributes
@Component
public class MonsterBill {

    private TariffsTable tariffsTable;
    private CountedBillTable countedBillTable;
    private FixedBillTable fixedBillTable;
    private ResultBillTable resultBillTable;
    private TableService tableService;


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

    public ResultBillTable initializeAndReturnResultBillTable(TableService tableService) throws Exception {
        resultBillTable = new ResultBillTable();

        this.tableService = tableService;

        if (initializeAndSaveCountedBillTable() &&
                initializeAndSaveFixedBillTable() &&
                initializeAndSaveTariffsTable()) {

            setResultBill();

           /* resultBillTable.setCountedBillTable(countedBillTable);
            resultBillTable.setTariffsTable(tariffsTable);
            resultBillTable.setFixedBillTable(fixedBillTable);*/
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

        tableService.save(countedBillTable);

       /* tableService.save(countedBillTable);*///save is needed here for previous Data Base row invocation

        return true;

    }

    private boolean initializeAndSaveTariffsTable() throws Exception {

        tariffsTable = new TariffsTable();

        tariffsTable.setColdWaterTariff((int)Math.floor(coldWaterTariff * 100));
        tariffsTable.setElectricityBeforeDelimiterTariff((int)Math.floor(electricityBeforeDelimiterTariff * 100));
        tariffsTable.setElectricityAfterDelimiterTariff((int)Math.floor(electricityAfterDelimiterTariff * 100));
        //add other values
//        resultBillTable.setTariffsTable(tariffsTable);

        tableService.save(tariffsTable);
        return true;
    }

    private boolean initializeAndSaveFixedBillTable() throws Exception {

        fixedBillTable = new FixedBillTable();

        fixedBillTable.setGarbageRemovalPrice((int)Math.floor(garbageRemovalPrice * 100));
        //add other values
//        resultBillTable.setFixedBillTable(fixedBillTable);

        tableService.save(fixedBillTable);
        return true;
    }


    private void setResultBill() {

        setCountedValues();


        resultBillTable.setGarbageRemoval(fixedBillTable.getGarbageRemovalPrice());

        resultBillTable.setTotalToPay(computeTotalToPay());
        resultBillTable.setIndicationDate(new Date());

    }

    private double computeTotalToPay() {
        return resultBillTable.getColdWater() + resultBillTable.getHotWater() +
                resultBillTable.getElectricity() + resultBillTable.getGarbageRemoval() +
                resultBillTable.getGasSupply() + resultBillTable.getHouseHeating() +
                resultBillTable.getRentService() + resultBillTable.getSewage();
    }

    private void setCountedValues() {

        CountedBillTable previousMonthBill = tableService.getPreviousCountedBill();

        if (previousMonthBill == null) {
            // if it is FIRST bill in the DataBase
            previousMonthBill = new CountedBillTable();
        }

        resultBillTable.setColdWater(computeColdWaterPrice(previousMonthBill));

        resultBillTable.setElectricity(computeElectricityPrice(previousMonthBill));


    }

    private int computeColdWaterPrice(CountedBillTable previousMonthBill) {
        System.out.println("countedBillTable " + countedBillTable);
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



        int electricityValue = countedBillTable.getElectricity() - previousMonthBill.getElectricity();

        System.out.println("electricityValue " + electricityValue);

        if (electricityValue <= electricityTariffDelimiter) {
            System.out.println("electricityValue <= 100");
            System.out.println("getElectricityBefore100Tariff " + tariffsTable.getElectricityBeforeDelimiterTariff());
            resultPrice = electricityValue * tariffsTable.getElectricityBeforeDelimiterTariff();
        } else /*if (electricityValue > electricityTariffDelimiter)*/ {
            System.out.println("electricityValue > 100");
            System.out.println("getElectricityAfter100Tariff " + getElectricityAfterDelimiterTariff());
            int priceBeforeDelimiter = (electricityValue - Math.abs(electricityTariffDelimiter - electricityValue))
                    * tariffsTable.getElectricityBeforeDelimiterTariff(); // 130 - (100-130)
            System.out.println("priceBeforeDelimiter " + priceBeforeDelimiter);

            int priceAfterDelimiter = Math.abs(electricityTariffDelimiter - electricityValue)
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
