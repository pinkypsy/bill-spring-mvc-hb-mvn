package ua.alvin.service;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.alvin.dao.TablesDAO;
import ua.alvin.entity.BillTable;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.TariffsTable;

@Service
public abstract class AbstractTableService implements TableService{
    //    @Qualifier(value = "tablesDAOImpl")//not necessary clarification, but for the readability purpose
    private final TablesDAO tablesDAO;



    @Autowired
    public AbstractTableService(TablesDAO tablesDAO) {
        this.tablesDAO = tablesDAO;
    }

    


    @Override
    public abstract void save(BillTable billTable);

    @Transactional
    @Override
    public CountedBillTable getPreviousCountedBill() {
        return tablesDAO.getPreviousCountedBill();
    }

    @Transactional
    @Override
    public TariffsTable getPreviousTariffsTable() {
        return tablesDAO.getPreviousTariffsTable();
    }


}
