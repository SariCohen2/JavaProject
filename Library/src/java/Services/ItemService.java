/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.HibernateUtil;
import Entity.Item;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author The user
 */
public class ItemService {
        public static List<Item> gettAll() {
        List<Item> list = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(Item.class).list();
            System.out.println("The updates went well!!");
            session.close();
        } catch (Exception ex) {
            System.out.println("An error occurred");
        }
        return list;
    }

}
