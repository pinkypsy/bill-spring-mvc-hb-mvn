package ua.alvin.dao;

import ua.alvin.entity.*;

import java.util.List;

public interface TablesDAO {

    void save(BillTable billTable);

    BillTable getBillByID(int billId);

//    TariffsTable getPreviousTariffsTable();


//    ResultBillTable showResultBillTable(int billId);
//
//    CountedBillTable showCountedBillTable(int billId);
//
//    FixedBillTable showFixedBillTable(int billId);
//
//    TariffsTable showTariffsTable(int billId);

    List <?> getAllRowsFromTable();

//    BillTable showBillTable(int billId);

    int getLastInsertedID();
}
