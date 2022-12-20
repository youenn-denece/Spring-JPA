package org.example;

import org.example.model.Account;
import org.example.model.Agency;
import org.example.model.Client;
import org.example.services.AccountServices;
import org.example.services.AgencyServices;
import org.example.services.ClientServices;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ClientServices clientServices = new ClientServices();
        clientServices.begin();
        clientServices.create(new Client("Majax", "Gérard", new Date("1943/04/28")));
        clientServices.send();
        clientServices.close();

        /*AgencyServices agencyServices = new AgencyServices();
        agencyServices.begin();
        agencyServices.create(new Agency("8, rue de la Monnaie 35000 Rennes", 1));
        agencyServices.send();
        agencyServices.close();

        AccountServices accountServices = new AccountServices();
        accountServices.begin();
        accountServices.create(new Account("Compte courant", "FR1430001019010000Z67067032", 1000.20, "Rennes", 1));
        accountServices.send();
        accountServices.close(); */
    }
}