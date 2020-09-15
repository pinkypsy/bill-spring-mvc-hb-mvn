package ua.alvin.service;

import ua.alvin.entity.BillTable;
import ua.alvin.entity.CountedBillTable;

public interface TableService {

    void save(BillTable billTable);

    CountedBillTable getPreviousCountedBill();
}
