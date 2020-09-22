package ua.alvin.service;

import ua.alvin.entity.*;

import java.util.List;

public interface TableService {

    void save(BillTable billTable);

    BillTable getBillByID(int billId);

//    TariffsTable getPreviousTariffsTable();

    List <? extends BillTable> getAllRowsFromTable();

//    BillTable showBillTable(int billId);

    int getLastInsertedID();

//    ResultBillTable showResultBillTable(int billId);
//
//    CountedBillTable showCountedBillTable(int billId);
//
//    FixedBillTable showFixedBillTable(int billId);
//
//    TariffsTable showTariffsTable(int billId);
}
