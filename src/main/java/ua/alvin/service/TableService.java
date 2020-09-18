package ua.alvin.service;

import org.hibernate.Transaction;
import ua.alvin.entity.BillTable;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.TariffsTable;

public interface TableService {

    void save(BillTable billTable);

    CountedBillTable getPreviousCountedBill();

    TariffsTable getPreviousTariffsTable();

}
