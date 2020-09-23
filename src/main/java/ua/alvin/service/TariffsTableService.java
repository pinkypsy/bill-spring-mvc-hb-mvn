package ua.alvin.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import ua.alvin.dao.TablesDAO;
import ua.alvin.entity.BillTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Scope(value="prototype")
//@Scope(value="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class TariffsTableService implements TableService {

    private final TablesDAO tablesDAO;


    @Autowired
    public TariffsTableService(@Qualifier(value = "tariffsTableDAOImpl") TablesDAO tablesDAO) {
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


}
