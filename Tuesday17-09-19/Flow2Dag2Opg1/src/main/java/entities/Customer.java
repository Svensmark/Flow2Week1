/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author emilt
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Customers.deleteAllRows", query = "DELETE FROM Customers"),
    @NamedQuery(name = "Customers.findAll", query = "SELECT j FROM Customers j"),
    @NamedQuery(name = "Customers.findById", query = "SELECT j FROM Customers j WHERE j.id = :id"),
    @NamedQuery(name = "Customers.deleteById", query = "DELETE j FROM Customers j WHERE j.id = :id"),
    @NamedQuery(name = "Customers.findByCustomersLine", query = "SELECT j FROM Customers j WHERE j.CustomersLine = :CustomersLine"),
    @NamedQuery(name = "Customers.findByAuthorName", query = "SELECT j FROM Customers j WHERE j.authorName = :authorName"),
    @NamedQuery(name = "Customers.findByReference", query = "SELECT j FROM Customers j WHERE j.reference = :reference"),
    @NamedQuery(name = "Customers.findByRating", query = "SELECT j FROM Customers j WHERE j.rating = :rating"),
    @NamedQuery(name = "Customers.findCount", query = "SELECT COUNT(j) FROM Customers j")
})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "PHONES",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID")
    )
    @MapKeyColumn(name = "PHONE")
    @Column(name = "DESCRIPTION")
    private Map<String, String> phones = new HashMap();

    @ElementCollection
    @CollectionTable(
            name = "HOBBIES",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID")
    )
    @Column(name = "HOBBY")
    private List<String> hobbies = new ArrayList();

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addHobby(String s) {
        this.hobbies.add(s);
    }

    public String getHobbies() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hobbies.size(); ++i) {
            sb.append(this.hobbies.get(i)).append(",");
        }
        return sb.toString();
    }

    public void addPhone(String phoneNo, String description) {
        this.phones.put(phoneNo, description);
    }

    public String getPhoneDescription(String phoneNo) {
        return this.phones.get(phoneNo);
    }
}
