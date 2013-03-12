/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author QuynhNguyen
 */
@Entity
public class Customer {
    @Id 
    @GeneratedValue (strategy= GenerationType.IDENTITY )
    private long id;
    private String name;
    private int age;
    @Temporal(TemporalType.DATE)
    private Date dateOfbirth;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfbirth() {
        return dateOfbirth;
    }

   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void setDateOfbirth(Calendar d) {
        this.dateOfbirth = dateOfbirth;
    }
    
    
    
    
}
