package ua.alvin.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fixed_bill")
public class FixedBillTable implements BillTable {

    @Id//mark for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//let mysql handle the generation of autoincrement
    @Column(name = "id")
    private int id;

    @Column(name = "house_heating")
    private int houseHeatingPrice;

    @Column(name = "rent_service")
    private int rentServicePrice;

    @Column(name = "garbage_removal")
    private int garbageRemovalPrice;

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

    public Date getIndicationDate() {
        return indicationDate;
    }

    public void setIndicationDate(Date indicationDate) {
        this.indicationDate = indicationDate;
    }

    public ResultBillTable getResultBillTable() {
        return resultBillTable;
    }

    public void setResultBillTable(ResultBillTable resultBillTable) {
        this.resultBillTable = resultBillTable;
    }

    @Override
    public String toString() {
        return "FixedBillTable{" +
                "id=" + id +
                ", houseHeating=" + houseHeatingPrice +
                ", rentService=" + rentServicePrice +
                ", garbageRemoval=" + garbageRemovalPrice +
                ", indicationDate=" + indicationDate +
                ", resultBillTable=" + resultBillTable +
                '}';
    }
}
