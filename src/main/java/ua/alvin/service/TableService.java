package ua.alvin.service;

import ua.alvin.entity.BillTable;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.ResultBillTable;

import java.util.List;

public interface TableService {

    void save(BillTable billTable);

    CountedBillTable getPreviousCountedBill();

//    TariffsTable getPreviousTariffsTable();

    List<ResultBillTable> showResultBillTable();
}
