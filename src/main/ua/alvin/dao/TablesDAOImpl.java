package main.ua.alvin.dao;

import main.ua.alvin.entity.BillTable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TablesDAOImpl implements TablesDAO{

    @Autowired
    private SessionFactory sessionFactory;


    public TablesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        System.out.println(2);
    }

    @Override
    public void save(BillTable billTable) {

        System.out.println("sessionFactory "+ sessionFactory);

        System.out.println("TablesDAOImpl save()");


    }
}
