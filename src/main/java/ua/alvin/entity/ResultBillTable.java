package ua.alvin.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "result_bill")
public class ResultBillTable implements BillTable {



    @Id//mark for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//let mysql handle the generation of autoincrement
    @Column(name = "id")
    private int id;

    @Column(name = "hot_water_cost")
    private double hotWater;

    @Column(name = "cold_water_cost")
    private double coldWater;

    @Column(name = "sewage_cost")
    private double sewage;

    @Column(name = "electricity_cost")
    private double electricity;

    @Column(name = "gas_supply_cost")
    private double gasSupply;

    @Column(name = "house_heating_cost")
    private double houseHeating;

    @Column(name = "rent_service_cost")
    private double rentService;

    @Column(name = "garbage_removal_cost")
    private double garbageRemoval;

    @Column(name = "total_to_pay")
    private double totalToPay;

    @Column(name = "indication_date")
    private Date indicationDate;

    @OneToOne(mappedBy = "resultBillTable", cascade = CascadeType.ALL)
    private CountedBillTable countedBillTable;

    @OneToOne(mappedBy = "resultBillTable", cascade = CascadeType.ALL)
    private FixedBillTable fixedBillTable;

    @OneToOne(mappedBy = "resultBillTable", cascade = CascadeType.ALL)
    private TariffsTable tariffsTable;

   /* @Qualifier(value = "resultBillTableService")
    @Transient
    @Autowired
    private TableService tableService;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHotWater() {
        return hotWater;
    }

    public void setHotWater(double hotWater) {
        this.hotWater = hotWater;
    }

    public double getColdWater() {
        return coldWater;
    }

    public void setColdWater(double coldWater) {
        this.coldWater = coldWater;
    }

    public double getSewage() {
        return sewage;
    }

    public void setSewage(double sewage) {
        this.sewage = sewage;
    }

    public double getElectricity() {
        return electricity;
    }

    public void setElectricity(double electricity) {
        this.electricity = electricity;
    }

    public double getGasSupply() {
        return gasSupply;
    }

    public void setGasSupply(double gasSupply) {
        this.gasSupply = gasSupply;
    }

    public double getHouseHeating() {
        return houseHeating;
    }

    public void setHouseHeating(double houseHeating) {
        this.houseHeating = houseHeating;
    }

    public double getRentService() {
        return rentService;
    }

    public void setRentService(double rentService) {
        this.rentService = rentService;
    }

    public double getGarbageRemoval() {
        return garbageRemoval;
    }

    public void setGarbageRemoval(double garbageRemoval) {
        this.garbageRemoval = garbageRemoval;
    }

    public String getIndicationDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(indicationDate);
    }

    public void setIndicationDate(Date indicationDate) {
        this.indicationDate = indicationDate;
    }

    public CountedBillTable getCountedBillTable() {
        return countedBillTable;
    }

    public void setCountedBillTable(CountedBillTable countedBillTable) {
        this.countedBillTable = countedBillTable;
    }

    public FixedBillTable getFixedBillTable() {
        return fixedBillTable;
    }

    public void setFixedBillTable(FixedBillTable fixedBillTable) {
        this.fixedBillTable = fixedBillTable;
    }

    public TariffsTable getTariffsTable() {
        return tariffsTable;
    }

    public void setTariffsTable(TariffsTable tariffsTable) {
        this.tariffsTable = tariffsTable;
    }

    @Override
    public String toString() {
        return "ResultBillTable{" +
                "id=" + id +
                ", hotWater=" + hotWater +
                ", coldWater=" + coldWater +
                ", sewage=" + sewage +
                ", electricity=" + electricity +
                ", gasSupply=" + gasSupply +
                ", houseHeating=" + houseHeating +
                ", rentService=" + rentService +
                ", garbageRemoval=" + garbageRemoval +
                ", indicationDate=" + indicationDate +
                ", countedBillTable=" + countedBillTable +
                ", fixedBillTable=" + fixedBillTable +
                '}';
    }


    public double getTotalToPay() {
        return totalToPay;
    }

    public void setTotalToPay(double totalToPay) {
        this.totalToPay = totalToPay;
    }
}
