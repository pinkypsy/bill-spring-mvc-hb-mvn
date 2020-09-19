package ua.alvin.dao;

import ua.alvin.entity.BillTable;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.ResultBillTable;
import ua.alvin.entity.TariffsTable;

import java.util.List;

public interface TablesDAO {

    void save(BillTable billTable);

    CountedBillTable getPreviousCountedBill();

    TariffsTable getPreviousTariffsTable();


    List<ResultBillTable> showResultBillTable();
}
