package ua.alvin.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tariffs")
public class TariffsTable implements BillTable {
    /*id int auto_increment primary key,
    cold_water int,
    hot_water int,
    sewage int,
    electricity_before100 int,
    electricity_after100 int,
    gas_supply int,
    valid_by_date date default(curdate())*/

    @Id//mark for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//let mysql handle the generation of autoincrement
    @Column(name = "id")
    private int id;

    @Column(name = "cold_water")
    private int coldWaterTariff;

    @Column(name = "hot_water")
    private int hotWaterTariff;

    @Column(name = "sewage")
    private int sewageTariff;

    @Column(name = "electricity_beforeDelimiter")
    private int electricityBeforeDelimiterTariff;

    @Column(name = "electricity_afterDelimiter")
    private int electricityAfterDelimiterTariff;

    @Column(name = "gas_supply")
    private int gasSupplyTariff;

    @Column(name = "valid_by_date")
    private Date dateTariffIsValid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id")
    private ResultBillTable resultBillTable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getElectricityBeforeDelimiterTariff() {
        return electricityBeforeDelimiterTariff;
    }

    public void setElectricityBeforeDelimiterTariff(int electricityBeforeDelimiterTariff) {
        this.electricityBeforeDelimiterTariff = electricityBeforeDelimiterTariff;
    }

    public int getElectricityAfterDelimiterTariff() {
        return electricityAfterDelimiterTariff;
    }

    public void setElectricityAfterDelimiterTariff(int electricityAfterDelimiterTariff) {
        this.electricityAfterDelimiterTariff = electricityAfterDelimiterTariff;
    }

    public int getGasSupplyTariff() {
        return gasSupplyTariff;
    }

    public void setGasSupplyTariff(int gasSupplyTariff) {
        this.gasSupplyTariff = gasSupplyTariff;
    }

    public Date getDateTariffIsValid() {
        return dateTariffIsValid;
    }

    public void setDateTariffIsValid(Date dateTariffIsValid) {
        this.dateTariffIsValid = dateTariffIsValid;
    }

    @Override
    public String toString() {
        return "TariffsTable{" +
                "id=" + id +
                ", coldWaterTariff=" + coldWaterTariff +
                ", hotWaterTariff=" + hotWaterTariff +
                ", sewageTariff=" + sewageTariff +
                ", electricityBefore100Tariff=" + electricityBeforeDelimiterTariff +
                ", electricityAfter100Tariff=" + electricityAfterDelimiterTariff +
                ", gasSupplyTariff=" + gasSupplyTariff +
                ", dateTariffIsValid=" + dateTariffIsValid +
                '}';
    }
}
