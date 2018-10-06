package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author Juste
 */
@Entity
@Table(name = "Person")
public class Person implements Serializable {
                                                                                                        
    private static final long serialVersionUID = 1L;
    @Id             
    @GeneratedValue(strategy = GenerationType.AUTO)
                        
    private Long id;
    private String mail;
    private String fname;
    private String lname;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Phone> phone = new ArrayList();
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Hobby> hobby = new ArrayList();
    
    public Person(String email, String fname, String lname){
        this.mail = email;
        this.fname = fname;
        this.lname = lname;
    }
    
    public Person(String email, String fname, String lname, List<Hobby> hobby, Address address, List<Phone> phone){
        this.mail = email;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.hobby = hobby;
        this.phone = phone;
    }
    
    public Person(long id, String email, String fname, String lname, List<Hobby> hobby, Address address, List<Phone> phone){
        this.id = id;
        this.mail = email;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.hobby = hobby;
        this.phone = phone;
    }
    
    public Person(){
        
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    public void addPhone(Phone p){
        this.phone.add(p);
    }
    
    public void addHobby(Hobby h){
        this.hobby.add(h);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Hobby> getHobby() {
        return hobby;
    }

    public void setHobby(List<Hobby> hobby) {
        this.hobby = hobby;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Person[ id=" + id + " ]";
    }
    
}