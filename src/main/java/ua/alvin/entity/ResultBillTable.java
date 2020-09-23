package ua.alvin.entity;

import org.springframework.web.bind.annotation.ModelAttribute;

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

    @Column(name = "filling_date")
    private Date fillingDate;

    @Transient
    private String formattedFillingDate;

    @OneToOne(mappedBy = "resultBillTable", cascade = CascadeType.ALL)
    private CountedBillTable countedBillTable;

    @OneToOne(mappedBy = "resultBillTable", cascade = CascadeType.ALL)
    private FixedBillTable fixedBillTable;

    @OneToOne(mappedBy = "resultBillTable", cascade = CascadeType.ALL)
    private TariffsTable tariffsTable;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHotWater() {
        return Double.parseDouble(String.format("%.2f", hotWater));
    }

    public void setHotWater(double hotWater) {
        this.hotWater = hotWater;
    }

    public double getColdWater() {
        return Double.parseDouble(String.format("%.2f", coldWater));
    }

    public void setColdWater(double coldWater) {
        this.coldWater = coldWater;
    }

    public double getSewage() {
        return Double.parseDouble(String.format("%.2f", sewage));
    }

    public void setSewage(double sewage) {
        this.sewage = sewage;
    }

    public double getElectricity() {
        return Double.parseDouble(String.format("%.2f", electricity));
    }

    public void setElectricity(double electricity) {
        this.electricity = electricity;
    }

    public double getGasSupply() {
        return Double.parseDouble(String.format("%.2f", gasSupply));
    }

    public void setGasSupply(double gasSupply) {
        this.gasSupply = gasSupply;
    }

    public double getHouseHeating() {
        return Double.parseDouble(String.format("%.2f", houseHeating));
    }

    public void setHouseHeating(double houseHeating) {
        this.houseHeating = houseHeating;
    }

    public double getRentService() {
        return Double.parseDouble(String.format("%.2f", rentService));
    }

    public void setRentService(double rentService) {
        this.rentService = rentService;
    }

    public double getGarbageRemoval() {
        return Double.parseDouble(String.format("%.2f", garbageRemoval));
    }

    public void setGarbageRemoval(double garbageRemoval) {
        this.garbageRemoval = garbageRemoval;
    }

    public Date getFillingDate() {
        return fillingDate;
    }

    public void setFillingDate(Date fillingDate) {
        this.fillingDate = fillingDate;
    }

    public String getFormattedFillingDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        formattedFillingDate = simpleDateFormat.format(fillingDate);
        return formattedFillingDate;
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

    @ModelAttribute("tariff")
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
                ", indicationDate=" + fillingDate +
                ", countedBillTable=" + countedBillTable +
                ", fixedBillTable=" + fixedBillTable +
                '}';
    }


    public double getTotalToPay() {
        return Double.parseDouble(String.format("%.2f", totalToPay));
    }

    public void setTotalToPay(double totalToPay) {
        this.totalToPay = totalToPay;
    }




}
