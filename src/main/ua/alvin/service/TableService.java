package main.ua.alvin.service;

import main.ua.alvin.entity.BillTable;
import main.ua.alvin.entity.CountedBillTable;

public interface TableService {

    void save(BillTable billTable);

    CountedBillTable getPreviousCountedBill();
}
