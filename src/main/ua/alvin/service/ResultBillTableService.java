package main.ua.alvin.service;

import main.ua.alvin.dao.TablesDAO;
import main.ua.alvin.entity.BillTable;
import main.ua.alvin.entity.CountedBillTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResultBillTableService implements TableService {
    @Autowired
//    @Qualifier(value = "tablesDAOImpl")//not necessary clarification, but for the readability purpose
    private TablesDAO tablesDAO;

    @Transactional
    @Override
    public void save(BillTable billTable) {
        tablesDAO.save(billTable);
    }


    @Override
    @Transactional
    public CountedBillTable getPreviousCountedBill(/*int id*/) {

        return tablesDAO.getPreviousCountedBill(/*id*/);
    }
}
