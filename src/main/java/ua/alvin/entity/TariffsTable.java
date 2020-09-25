package ua.alvin.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.text.SimpleDateFormat;
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

//    @Value("434")
//    @ColumnDefault("'${coldWaterTariff}'")
    @Column(name = "cold_water")
    private double coldWaterTariff;

    @Column(name = "hot_water")
    private double hotWaterTariff;

    @Column(name = "sewage")
    private double sewageTariff;

    @Column(name = "electricity_beforeDelimiter")
    private double electricityBeforeDelimiterTariff;

    @Column(name = "electricity_afterDelimiter")
    private double electricityAfterDelimiterTariff;

    @Column(name = "gas_supply")
    private double gasSupplyTariff;

    @Column(name = "house_heating")
    private double houseHeatingTariff;

    @Column(name = "filling_date")
    private Date fillingDate;

    /*
If used electricity in current month is bigger than electricityTariffDelimiter,
then electricity tariff for remains is greater.

I.e. if difference on electricity between previous and current month is 99 kVt,
then electricityTariff = 90.
If difference is 150 kVt, then:
for 100 kVt: electricityTariff = 90
and for the remaining 50 kVt: electricityTariff = 168.
 */
    @Column(name = "electricity_tariff_delimiter")
//    @Value("${electricityTariffDelimiter}")
    private short electricityTariffDelimiter;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id")
    private ResultBillTable resultBillTable;

    @Transient
    private String formattedFillingDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getFillingDate() {
        return fillingDate;
    }

    public void setFillingDate(Date fillingDate) {
        this.fillingDate = fillingDate;
    }

    public String getFormattedFillingDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("simpleDateFormat " + simpleDateFormat);
        System.out.println("fillingDate " + fillingDate);
        formattedFillingDate = simpleDateFormat.format(fillingDate);

        return formattedFillingDate;
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
                ", dateTariffIsValid=" + fillingDate +
                '}';
    }

    public short getElectricityTariffDelimiter() {
        return electricityTariffDelimiter;
    }

    public void setElectricityTariffDelimiter(short electricityTariffDelimiter) {
        this.electricityTariffDelimiter = electricityTariffDelimiter;
    }

    public double getHouseHeatingTariff() {
        return houseHeatingTariff;
    }

    public void setHouseHeatingTariff(double houseHeatingTariff) {
        this.houseHeatingTariff = houseHeatingTariff;
    }
}
