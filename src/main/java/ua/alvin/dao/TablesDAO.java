package ua.alvin.dao;

import org.hibernate.Transaction;
import ua.alvin.entity.BillTable;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.TariffsTable;

public interface TablesDAO {

    void save(BillTable billTable);

    CountedBillTable getPreviousCountedBill();

    TariffsTable getPreviousTariffsTable();


}
