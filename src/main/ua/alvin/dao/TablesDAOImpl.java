package main.ua.alvin.dao;

import main.ua.alvin.entity.BillTable;
import main.ua.alvin.entity.CountedBillTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class TablesDAOImpl implements TablesDAO {

    private static long lastId;

    @Autowired
    private SessionFactory sessionFactory;


    public TablesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        System.out.println(2);
    }

    public static long getLastId() {
        return lastId;
    }

    @Override
    public void save(BillTable billTable) {

        System.out.println("sessionFactory " + sessionFactory);

        Session session = sessionFactory.getCurrentSession();


        session.saveOrUpdate(billTable);


//        session.close();

//        System.out.println("TablesDAOImpl save()");


    }

    @Override
    public CountedBillTable getPreviousCountedBill() {

        Session session = sessionFactory.getCurrentSession();


        Long lastId1 = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID() from counted_bill").setMaxResults(1).uniqueResult()).longValue();
//        lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID() from counted_bill").uniqueResult()).longValue();


        System.out.println("lastId " + lastId1);
        return session.get(CountedBillTable.class, (int)(lastId1 - 1));
    }
}
