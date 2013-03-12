/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author QuynhNguyen
 */
public class test {
    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("JavaApplication2PU");
    static EntityManager em= emf.createEntityManager();
    
    public static void insertCustomer(Customer c)
    {
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally
        {
        em.close();
        }
    }
    public List<Customer> getListCus(long id)
    {
        try {
             String sql="Select tbl from Customer tbl where id=?1";
        return em.createQuery(sql).setParameter(1, id).getResultList();
   
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        finally
        {
            em.close();
        }
 }
    public static void updateCustomer(Customer c)
    {
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        finally
        {
            em.close();
        }
    }
    public static void main(String[] args) {
        Customer c= new Customer();
        Calendar d= Calendar.getInstance();
        d.set(1990, 12, 8);
        c.setName("nguyen van an");
        c.setAge(15);
        c.setDateOfbirth(d);
        insertCustomer(c);
        String name = "abc";
        long id=1;
        
                
    }
    
}
