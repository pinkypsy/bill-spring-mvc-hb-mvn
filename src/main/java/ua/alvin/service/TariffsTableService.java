package ua.alvin.service;

import ua.alvin.dao.TablesDAO;
import ua.alvin.entity.BillTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.alvin.entity.CountedBillTable;

@Service
public class TariffsTableService extends AbstractTableService {

    //    @Qualifier(value = "tablesDAOImpl")//not necessary clarification, but for the readability purpose
    private final TablesDAO tablesDAO;

    @Autowired
    public TariffsTableService(TablesDAO tablesDAO) {
        super(tablesDAO);
        this.tablesDAO = tablesDAO;
    }


    @Transactional
    @Override
    public void save(BillTable billTable) {

        tablesDAO.save(billTable);

    }


}
