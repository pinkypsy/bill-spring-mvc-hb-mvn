package ua.alvin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.alvin.dao.TablesDAO;
import ua.alvin.entity.BillTable;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.ResultBillTable;

import java.util.List;

@Service
public abstract class AbstractTableService implements TableService{

    private final TablesDAO tablesDAO;



    @Autowired
    public AbstractTableService(@Qualifier(value = "countedBillTableDAOImpl")TablesDAO tablesDAO) {
        this.tablesDAO = tablesDAO;
    }

    @Transactional
    @Override
    public CountedBillTable getPreviousCountedBill() {
        return tablesDAO.getPreviousCountedBill();
    }

//    @Transactional
//    @Override
//    public List<?> getAllRowsFromTable() {
//        return tablesDAO.getAllRowsFromTable();
//    }


//    @Override
//    public abstract void save(BillTable billTable);


//
//    @Transactional
//    @Override
//    public TariffsTable getPreviousTariffsTable() {
//        return tablesDAO.getPreviousTariffsTable();
//    }


}
