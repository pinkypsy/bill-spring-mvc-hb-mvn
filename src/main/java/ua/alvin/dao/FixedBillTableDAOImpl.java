package ua.alvin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.alvin.entity.BillTable;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.FixedBillTable;

import java.util.List;

@Repository
public class FixedBillTableDAOImpl implements TablesDAO {

    private int lastInsertedID;

    private SessionFactory sessionFactory;



    @Autowired
    public FixedBillTableDAOImpl(SessionFactory sessionFactory) {
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
    public BillTable getBillByID(int billId) {

        Session session = sessionFactory.getCurrentSession();

        return session.get(FixedBillTable.class, (billId));
    }



    @Override
    public List<FixedBillTable> getAllRowsFromTable() {
        Session session = sessionFactory.getCurrentSession();

        Query<FixedBillTable> fixedBillTableQuery =
                session.createQuery("from FixedBillTable", FixedBillTable.class);


        return fixedBillTableQuery.getResultList();
    }


    @Override
    public int getLastInsertedID() {

        Session session = sessionFactory.getCurrentSession();

        lastInsertedID = (int) (session.createSQLQuery("SELECT MAX(id) from fixed_bill").setMaxResults(1).uniqueResult());

        System.out.println("lastInsertedID in DAO " + lastInsertedID);
        return lastInsertedID;
    }

}
