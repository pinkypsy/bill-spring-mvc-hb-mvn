package ua.alvin.service;

import org.springframework.beans.factory.annotation.Qualifier;
import ua.alvin.dao.TablesDAO;
import ua.alvin.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResultBillTableService extends AbstractTableService {

    private final TablesDAO tablesDAO;

    @Autowired
    public ResultBillTableService(@Qualifier(value = "resultBillTableDAOImpl")TablesDAO tablesDAO) {
        super(tablesDAO);
        this.tablesDAO = tablesDAO;
    }


    @Transactional
    @Override
    public void save(BillTable billTable) {
        tablesDAO.save(billTable);
    }

    @Transactional
    @Override
    public BillTable showBillTable(int billId) {
        return tablesDAO.showBillTable(billId);
    }

    @Transactional
    @Override
    public List<?> getAllRowsFromTable() {
        return tablesDAO.getAllRowsFromTable();
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
