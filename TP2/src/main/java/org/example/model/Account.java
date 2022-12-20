package org.example.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String libel;
    @Column(nullable = false, length = 27)
    private String iban;
    @Column(precision = 10, scale = 2)
    private Double sold;
    @ManyToOne
    @JoinColumn(name="AGENCY_ID")
    private Agency agency;
    @ManyToMany
    @JoinTable(name="ACC_CLI", joinColumns = @JoinColumn(name = "ACC_ID", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="CLI_ID", referencedColumnName = "id"))
    private Collection<Client> clients;

    public Account(){}
    public Account(String libel, String iban, Double sold, Agency agency, Collection<Client> clients) {
        this.libel = libel;
        this.iban = iban;
        this.sold = sold;
        this.agency = agency;
        this.clients = clients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibel() {
        return libel;
    }

    public void setLibel(String libel) {
        this.libel = libel;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getSold() {
        return sold;
    }

    public void setSold(Double sold) {
        this.sold = sold;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Collection<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", libel='" + libel + '\'' +
                ", iban='" + iban + '\'' +
                ", sold=" + sold +
                ", agency=" + agency +
                ", clients=" + clients +
                '}';
    }
}
