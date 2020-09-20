package ua.alvin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.alvin.entity.*;

import java.math.BigInteger;
import java.util.List;

    @Repository
    public class CountedBillTableDAOImpl implements TablesDAO {


        private SessionFactory sessionFactory;

        @Autowired
        public CountedBillTableDAOImpl(SessionFactory sessionFactory) {
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
        public CountedBillTable getPreviousCountedBill() {

            Session session = sessionFactory.getCurrentSession();


            int lastId1 = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID() from counted_bill").setMaxResults(1).uniqueResult()).intValue();
//        lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID() from counted_bill").uniqueResult()).longValue();


            System.out.println("lastId " + lastId1);
            return session.get(CountedBillTable.class, (lastId1 - 1));
        }



        @Override
        public List<CountedBillTable> getAllRowsFromTable() {
            Session session = sessionFactory.getCurrentSession();

            Query<CountedBillTable> countedBillTableQuery =
                    session.createQuery("from CountedBillTable", CountedBillTable.class);


            return countedBillTableQuery.getResultList();
        }

        @Override
        public CountedBillTable showBillTable(int billId) {

            Session session = sessionFactory.getCurrentSession();

            return session.get(CountedBillTable.class, billId);
        }


//    @Override
//    public ResultBillTable showResultBillTable(int billId) {
//
//        Session session = sessionFactory.getCurrentSession();
//
//        return session.get(ResultBillTable.class, billId);
//    }
//
//    @Override
//    public CountedBillTable showCountedBillTable(int billId) {
//
//        Session session = sessionFactory.getCurrentSession();
//
//        return session.get(CountedBillTable.class, billId);
//    }
//
//
//
//    @Override
//    public FixedBillTable showFixedBillTable(int billId) {
//        Session session = sessionFactory.getCurrentSession();
//
//        return session.get(FixedBillTable.class, billId);
//    }
//
//    @Override
//    public TariffsTable showTariffsTable(int billId) {
//        Session session = sessionFactory.getCurrentSession();
//
//        return session.get(TariffsTable.class, billId);
//    }
    }


