/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.HibernateUtil;
import Entity.Loan;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author The user
 */
public class LoanService {

    public static List<Loan> gettAll() {
        List<Loan> list = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(Loan.class).list();
            System.out.println("The data was retrieved successfully!!");
            session.close();
        } catch (Exception ex) {
            System.out.println("An error occurred");
        }

        return list;
    }

    public static void post(Loan loan) {
        Transaction tr = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.save(loan);
            System.out.println("The updates went well!!");
            tr.commit();;
            session.close();

        } catch (Exception ex) {
            tr.rollback();;
            System.out.println("An error occurred");
        }
    }

    public static void updateLoan(int id) {//Put 
        Transaction tr = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            Loan l = (Loan) session.get(Loan.class, id);
            session.evict(l);
            l.setActiveLoan(false);
            session.save(l);
            System.out.println("The updates went well!!");
            tr.commit();;
            session.close();
        } catch (Exception ex) {
            System.out.println("An error occurred");
            tr.rollback();
        }
    }

}
