package org.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Agency {
    @Id
    @GeneratedValue
    private int id;
    private String adress;
    @OneToMany(mappedBy = "agency")
    private Collection<Account> accounts;

    public Agency(){}
    public Agency(String adress) {
        this.adress = adress;
    }
    public Agency(String adress, Collection<Account> accounts) {
        this.adress = adress;
        this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "id=" + id +
                ", adress='" + adress + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
