package ua.alvin.service;

import ua.alvin.entity.*;

import java.util.List;

public interface TableService {

    void save(BillTable billTable);

    CountedBillTable getPreviousCountedBill();

//    TariffsTable getPreviousTariffsTable();

    List <?> getAllRowsFromTable();

    BillTable showBillTable(int billId);

//    ResultBillTable showResultBillTable(int billId);
//
//    CountedBillTable showCountedBillTable(int billId);
//
//    FixedBillTable showFixedBillTable(int billId);
//
//    TariffsTable showTariffsTable(int billId);
}
