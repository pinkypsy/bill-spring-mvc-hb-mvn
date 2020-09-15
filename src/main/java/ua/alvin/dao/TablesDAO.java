package ua.alvin.dao;

import ua.alvin.entity.BillTable;
import ua.alvin.entity.CountedBillTable;

public interface TablesDAO {

    void save(BillTable billTable);

    CountedBillTable getPreviousCountedBill(/*int id*/);
}
