package ua.alvin.service;

import ua.alvin.dao.TablesDAO;
import ua.alvin.entity.BillTable;
import ua.alvin.entity.CountedBillTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/*
@Service
public class CountedBillTableService extends AbstractTableService{
    //    @Qualifier(value = "tablesDAOImpl")//not necessary clarification, but for the readability purpose
    private final TablesDAO tablesDAO;

    @Autowired
    public CountedBillTableService(TablesDAO tablesDAO) {
        super(tablesDAO);
        this.tablesDAO = tablesDAO;
    }

    @Transactional
    @Override
    public void save(BillTable billTable) {
        tablesDAO.save(billTable);
    }


}*/
