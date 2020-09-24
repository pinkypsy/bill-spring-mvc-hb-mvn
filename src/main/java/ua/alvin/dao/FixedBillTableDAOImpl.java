package ua.alvin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.alvin.entity.BillTable;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.FixedBillTable;

import javax.annotation.PreDestroy;
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

    @PreDestroy
    public void close(){
        System.out.println("sessionFactory FB " + sessionFactory);
        sessionFactory.close();
    }

    @Override
    public int getLastInsertedID() {

        Session session = sessionFactory.getCurrentSession();


        try {
            lastInsertedID = (int) (session.createSQLQuery("SELECT MAX(id) from fixed_bill").setMaxResults(1).uniqueResult());
        } catch (NullPointerException e) {
            lastInsertedID = 0;
        }

        System.out.println("lastInsertedID in DAO " + lastInsertedID);
        return lastInsertedID;
    }

}
