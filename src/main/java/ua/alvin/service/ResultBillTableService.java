package ua.alvin.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import ua.alvin.dao.TablesDAO;
import ua.alvin.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Scope(value="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class ResultBillTableService implements TableService {

    private final TablesDAO tablesDAO;

    @Autowired
    public ResultBillTableService(@Qualifier(value = "resultBillTableDAOImpl") TablesDAO tablesDAO) {
        this.tablesDAO = tablesDAO;
    }


    @Transactional
    @Override
    public void save(BillTable billTable) {
        tablesDAO.save(billTable);
    }

    @Transactional
    @Override
    public BillTable getBillByID(int billId) {
        return tablesDAO.getBillByID(billId);
    }

    @Transactional
    @Override
    public List<? extends BillTable> getAllRowsFromTable() {
        return tablesDAO.getAllRowsFromTable();
    }

    @Transactional
    @Override
    public int getLastInsertedID() {
        return tablesDAO.getLastInsertedID();
    }

//    @Transactional
//    @Override
//    public List<ResultBillTable> getAllResultBillTableList() {
//        return tablesDAO.getAllResultBillTableList();
//    }

//    @Transactional
//    @Override
//    public CountedBillTable showCountedBillTable(int billId) {
//        return tablesDAO.showCountedBillTable(billId);
//    }
//
//    @Transactional
//    @Override
//    public ResultBillTable showResultBillTable(int billId) {
//        return tablesDAO.showResultBillTable(billId);
//    }
//
//    @Transactional
//    @Override
//    public TariffsTable showTariffsTable(int billId) {
//        return tablesDAO.showTariffsTable(billId);
//    }
//
//    @Transactional
//    @Override
//    public FixedBillTable showFixedBillTable(int billId) {
//        return tablesDAO.showFixedBillTable(billId);
//    }

}
