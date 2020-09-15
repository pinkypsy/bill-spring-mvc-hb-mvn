package ua.alvin.service;

import ua.alvin.dao.TablesDAO;
import ua.alvin.entity.BillTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.alvin.entity.CountedBillTable;

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

    @Override
    public CountedBillTable getPreviousCountedBill() {
        return new CountedBillTable();//temp null object
    }

//    @Override
//    public CountedBillTable getPreviousCountableBill(int id) {
//        return null;
//    }
}
