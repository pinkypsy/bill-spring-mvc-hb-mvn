package ua.alvin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.alvin.entity.BillTable;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.TariffsTable;

import java.math.BigInteger;

@Repository
public class TablesDAOImpl implements TablesDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public TablesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        System.out.println(2);
    }


    @Override
    public void save(BillTable billTable) {

        System.out.println("sessionFactory " + sessionFactory);

        Session session = sessionFactory.getCurrentSession();


        session.saveOrUpdate(billTable);


    }

    @Override
    public CountedBillTable getPreviousCountedBill()  {

        Session session = sessionFactory.getCurrentSession();


        int lastId1 = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID() from counted_bill").setMaxResults(1).uniqueResult()).intValue();
//        lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID() from counted_bill").uniqueResult()).longValue();


        System.out.println("lastId " + lastId1);
        return session.get(CountedBillTable.class, (lastId1 - 1));
    }

    @Override
    public TariffsTable getPreviousTariffsTable() {
        Session session = sessionFactory.getCurrentSession();


        int lastId1 = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID() from tariffs").setMaxResults(1).uniqueResult()).intValue();
//        lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID() from counted_bill").uniqueResult()).longValue();


        System.out.println("lastId " + lastId1);
        return session.get(TariffsTable.class, (lastId1 - 1));
    }


  /*  @Override
    public CountedBillTable getPreviousCountedBill() {

        Session session = sessionFactory.getCurrentSession();


        int lastId =
                ((BigInteger) session
                        .createSQLQuery(
                                "SELECT MAX(id) from counted_bill").setMaxResults(1).uniqueResult()).intValue();


        System.out.println("lastId " + lastId);
        return session.get(CountedBillTable.class, (lastId - 1));
    }*/
}