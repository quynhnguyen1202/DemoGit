/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;

/**
 *
 * @author QuynhNguyen
 */
public class testdb {

    public static boolean insert(Person ps) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ps);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
            emf.close();
        }

    }

    public static List<Person> getListPerson(Date date) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU");
        EntityManager em = emf.createEntityManager();
        try {
            
        String sql = "Select tbl.name from Person tbl where tbl.dob =?1";

        return (List<Person>) em.createQuery(sql).setParameter(1, date, TemporalType.DATE).getResultList();
        } catch (Exception e) {
            return null;
        }finally{
            em.close();
            emf.close();
        }
        


    }
    
//     public static List<Object> getListObject(long id) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU");
//        EntityManager em = emf.createEntityManager();
//        try {
//            
//        //String sql = "Select tbl.name from Person tbl where tbl.id = ?1";
//            String sql ="Select tbl from Person tbl";
//        
//        return em.createQuery(sql).setParameter(1, id).getResultList();
//        } catch (Exception e) {
//            return null;
//        }finally{
//            em.close();
//            emf.close();
//        }}
        
        public static List<Object> getListObjects(long id) {
            EntityManagerFactory emf= Persistence.createEntityManagerFactory("JavaApplication2PU");
            EntityManager em= emf.createEntityManager();
            try {
                String sql="Select * tbl.name from Person tbl where tbl.id = ?1";
                return em.createQuery(sql).setParameter(1, id).getResultList();
            } catch (Exception e) {
                return null;
                
            }
            finally 
            {
            em.close();
            }
//        
  }

    

    public static boolean update(Person ps) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(ps);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            em.close();
            emf.close();
        }

    }

//    public static void main(String[] args) {
////        Person p = new Person();
////        p.setDob(new Date());
////        insert(p); 
////        
////        Calendar c  =Calendar.getInstance();
////        c.set(2010, 11, 9);
////        
//        Date c= new Date(2013,03,11);
//        List<Person> l= getListPerson(c);
//      //List<Person> l= getListPerson(c.getTime());
//        System.out.println("=============== "+l.size());
//    }

    }

