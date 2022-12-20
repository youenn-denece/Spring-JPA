package org.example.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String firstName;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @ManyToMany(mappedBy = "clients")
    private Collection<Account> accounts;

    public Client(){}

    public Client(String name, String firstName, Date birthDate, Collection<Account> accounts) {
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", accounts=" + accounts +
                '}';
    }
}
