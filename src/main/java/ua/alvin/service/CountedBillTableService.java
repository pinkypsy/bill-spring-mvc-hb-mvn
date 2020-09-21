package ua.alvin.service;

import org.springframework.beans.factory.annotation.Qualifier;
import ua.alvin.dao.TablesDAO;
import ua.alvin.entity.BillTable;
import ua.alvin.entity.CountedBillTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountedBillTableService extends AbstractTableService {

    private final TablesDAO tablesDAO;

    @Autowired
    public CountedBillTableService(@Qualifier(value = "countedBillTableDAOImpl") TablesDAO tablesDAO) {
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

    @Transactional
    @Override
    public int getLastInsertedID() {
        return tablesDAO.getLastInsertedID();
    }

}
