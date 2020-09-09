package main.ua.alvin.dao;

import main.ua.alvin.entity.BillTable;
import main.ua.alvin.entity.CountedBillTable;

public interface TablesDAO {

    void save(BillTable billTable);

    CountedBillTable getPreviousCountedBill(/*int id*/);
}
