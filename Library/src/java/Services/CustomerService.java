/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Customer;
import Entity.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author The user
 */
public class CustomerService {
       public static List<Customer> getAll() {
        List<Customer> list = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(Customer.class).list();
            System.out.println("The updates went well!!");
            session.close();
        } catch (Exception ex) {
            System.out.println("An error occurred");
        }

        return list;
    }
    
}
