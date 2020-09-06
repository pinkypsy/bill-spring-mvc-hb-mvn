package main.ua.alvin.service;

import main.ua.alvin.dao.TablesDAO;
import main.ua.alvin.dao.TablesDAOImpl;
import main.ua.alvin.entity.BillTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TariffsTableService implements TableService{

    @Autowired
//    @Qualifier(value = "tablesDAOImpl")//not necessary clarification, but for the readability purpose
    private TablesDAO tablesDAO;

    @Transactional
    @Override
    public void save(BillTable billTable) {
        System.out.println("inside TTService " + billTable);
        System.out.println("inside TTService tablesDAO " + tablesDAO);
        tablesDAO.save(billTable);

    }
}
