package ua.alvin.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "counted_bill")
public class CountedBillTable implements BillTable {

    @Id//mark for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//let mysql handle the generation of autoincrement
    @Column(name = "id")
    private int id;

    @Column(name = "hot_water")
    private int hotWater;

    @Column(name = "cold_water")
    private int coldWater;

    @Column(name = "sewage")
    private int sewage;

    @Column(name = "electricity")
    private int electricity;

    @Column(name = "gas_supply")
    private int gasSupply;

    @Column(name = "house_heating")
    private int houseHeating;

    @Column(name = "indication_date")
    private Date indicationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id")
    private ResultBillTable resultBillTable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ResultBillTable getResultBillTable() {
        return resultBillTable;
    }

    public void setResultBillTable(ResultBillTable resultBillTable) {
        this.resultBillTable = resultBillTable;
    }

    public Date getIndicationDate() {
        return indicationDate;
    }

    public void setIndicationDate(Date indicationDate) {
        this.indicationDate = indicationDate;
    }

    @Override
    public String toString() {
        return "CountedBillTable{" +
                "id=" + id +
                ", hotWater=" + hotWater +
                ", coldWater=" + coldWater +
                ", sewage=" + sewage +
                ", electricity=" + electricity +
                ", gasSupply=" + gasSupply +
                ", resultBillTable=" + resultBillTable +
                ", indicationDate=" + indicationDate +
                '}';
    }

    public int getHouseHeating() {
        return houseHeating;
    }

    public void setHouseHeating(int houseHeating) {
        this.houseHeating = houseHeating;
    }
}
