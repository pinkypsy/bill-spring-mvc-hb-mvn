package ua.alvin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.alvin.entity.BillTable;
import ua.alvin.entity.CountedBillTable;
import ua.alvin.entity.TariffsTable;

import java.util.List;

@Repository
public class TariffsTableDAOImpl implements TablesDAO {

    private int lastInsertedID;

    private SessionFactory sessionFactory;


    @Autowired
    public TariffsTableDAOImpl(SessionFactory sessionFactory) {
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

        return session.get(TariffsTable.class, (billId));
    }



    @Override
    public List<TariffsTable> getAllRowsFromTable() {
        Session session = sessionFactory.getCurrentSession();

        Query<TariffsTable> tariffsTableQuery =
                session.createQuery("from TariffsTable", TariffsTable.class);


        return tariffsTableQuery.getResultList();
    }

   /* @Override
    public TariffsTable showBillTable(int billId) {

        Session session = sessionFactory.getCurrentSession();

        return session.get(TariffsTable.class, billId);
    }*/

    @Override
    public int getLastInsertedID() {

        Session session = sessionFactory.getCurrentSession();

        lastInsertedID = (int) (session.createSQLQuery("SELECT MAX(id) from tariffs").setMaxResults(1).uniqueResult());

        System.out.println("lastInsertedID in DAO " + lastInsertedID);
        return lastInsertedID;
    }
}
