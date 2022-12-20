package org.example.domaines;

import org.example.model.Account;
import org.example.model.Agency;
import org.example.model.Client;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Menu {

    public static void exo() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transac = em.getTransaction();
        // ajout Client
        transac.begin();
        Client client1 = new Client("Arnaud", "Bernard", new Date("1943/04/28"));
        em.persist(client1);
        Client client2 = new Client("Tapie", "Bernard", new Date("1952/05/12"));
        em.persist(client2);
        Client client3 = new Client("Cahuzac", "Jérome", new Date("1948/06/14"));
        em.persist(client3);
        Client client4 = new Client("Kerviel", "Jérome", new Date("1975/02/01"));
        em.persist(client4);
        Client client5 = new Client("Guéant", "Claude", new Date("1947/09/22"));
        em.persist(client5);
        Client client6 = new Client("Fillon", "Pénélope", new Date("1952/01/01"));
        em.persist(client6);
        Client client7 = new Client("Platini", "Michel", new Date("1947/09/10"));
        em.persist(client7);
        Client client8 = new Client("Fillon", "François", new Date("1950/10/12"));
        em.persist(client8);
        // Collection de Clients
        Collection<Client> clientArnaud = new ArrayList<>();
        clientArnaud.add(client1);
        Collection<Client> clientFillon = new ArrayList<>();
        clientFillon.add(client6);
        clientFillon.add(client8);
        Collection<Client> clientPlatini = new ArrayList<>();
        clientPlatini.add(client7);
        Collection<Client> clientGueant = new ArrayList<>();
        clientGueant.add(client5);
        Collection<Client> clientCahuzac = new ArrayList<>();
        clientCahuzac.add(client3);
        Collection<Client> clientKerviel = new ArrayList<>();
        clientKerviel.add(client4);
        // Ajout d'agences
        Agency agency1 = new Agency("10 Pl. de la Navigation, 1201 Genève, Suisse");
        em.persist(agency1);
        Agency agency2 = new Agency("16 Rue Merle-d'Aubigné, 1207 Genève, Suisse");
        em.persist(agency2);
        Agency agency3 = new Agency("14 Bd Royal, 2449 Luxembourg");
        em.persist(agency3);
        Agency agency4 = new Agency("8 Rue de la Monnaie, 35000 Rennes");
        em.persist(agency4);
        // Ajout de comptes
        Account account1 =new Account("Compte épargne", "LX1430001019010000Z67067032", 1000203.20);
        em.persist(account1);
        Account account2 = new Account("Valise Kadhafi", "SU1430211019010000Z67023032", 201000.10);
        em.persist(account2);
        Account account3 = new Account("Valise Kadhafi", "SU1430001019010000Z67067032", 100036.10);
        em.persist(account3);
        Account account4 = new Account("Compte épargne", "LX2542081019010000Z67067032", 236520.10);
        em.persist(account4);
        Account account5 = new Account("Compte courant", "FR1430001019010000Z67067032", 36.10);
        em.persist(account5);
        Account account6 = new Account("Virement FIFA", "SU1430001019010000Z67067032", 236521.00);
        em.persist(account6);
        Account account7 = new Account("Compte courant", "FR1430001019010000Z67067032", 236.10);
        em.persist(account7);
        Account account8 = new Account("Compte courant", "FR1430001019010000Z67067032", 396.10);
        em.persist(account8);
        Account account9 = new Account("Compte caché", "SU1430001019010000Z67067032", 3598735.90);
        em.persist(account9);
        // Collection de comptes par clients
        Collection<Account> accountFillon = new ArrayList<>();
        accountFillon.add(account7);
        accountFillon.add(account3);
        accountFillon.add(account4);
        Collection<Account> accountPlatini = new ArrayList<>();
        accountPlatini.add(account6);
        Collection<Account> accountArnaud = new ArrayList<>();
        accountArnaud.add(account1);
        Collection<Account> accountGueant = new ArrayList<>();
        accountGueant.add(account2);
        accountGueant.add(account5);
        Collection<Account> accountKerviel = new ArrayList<>();
        accountKerviel.add(account6);
        accountKerviel.add(account9);
        Collection<Account> accountCahuzac = new ArrayList<>();
        accountCahuzac.add(account8);
        // Collection de compte par agence
        Collection<Account> accountA1 = new ArrayList<>();
        accountA1.add(account2);
        accountA1.add(account6);
        accountA1.add(account9);
        Collection<Account> accountA2 = new ArrayList<>();
        accountA2.add(account3);
        Collection<Account> accountA3 = new ArrayList<>();
        accountA3.add(account1);
        accountA3.add(account4);
        Collection<Account> accountA4 = new ArrayList<>();
        accountA4.add(account5);
        accountA4.add(account7);
        accountA4.add(account8);
        // connexion OneToMany / ManyToOne
        account1.setAgency(agency3);
        account2.setAgency(agency1);
        account3.setAgency(agency2);
        account4.setAgency(agency3);
        account5.setAgency(agency4);
        account6.setAgency(agency1);
        account7.setAgency(agency4);
        account8.setAgency(agency4);
        account9.setAgency(agency1);
        agency1.setAccounts(accountA1);
        agency2.setAccounts(accountA2);
        agency3.setAccounts(accountA3);
        agency4.setAccounts(accountA4);
        // Connexion ManyToMany
        client1.setAccounts(accountArnaud);
        account1.setClients(clientArnaud);
        em.persist(client1);
        em.persist(account1);
        client3.setAccounts(accountCahuzac);
        account8.setClients(clientCahuzac);
        em.persist(client3);
        em.persist(account8);
        client4.setAccounts(accountKerviel);
        account6.setClients(clientKerviel);
        account9.setClients(clientKerviel);
        em.persist(client4);
        em.persist(account6);
        em.persist(account9);
        client5.setAccounts(accountGueant);
        account2.setClients(clientGueant);
        account5.setClients(clientGueant);
        em.persist(client5);
        em.persist(account2);
        em.persist(account5);
        client6.setAccounts(accountFillon);
        client8.setAccounts(accountFillon);
        account3.setClients(clientFillon);
        account4.setClients(clientFillon);
        account7.setClients(clientFillon);
        em.persist(client6);
        em.persist(client8);
        em.persist(account3);
        em.persist(account4);
        em.persist(account7);
        client7.setAccounts(accountPlatini);
        account6.setClients(clientPlatini);
        em.persist(client7);
        em.persist(account6);

        transac.commit();
        System.out.println("##############  Affichage informations ############## ");
        Query query= em.createQuery("select a from Agency a");
        List<Agency> agencies = query.getResultList();
        for(Agency a : agencies){
            System.out.println("######################");
            System.out.println("Agence avec l'id : "+a.getId()+" a l'adresse : "+a.getAdress());
            for(Account c : a.getAccounts()){
                System.out.println("\tCompte avec l'id : "+c.getId()+" libelle : "+c.getLibel()+" solde : "+c.getSold());
                System.out.println("\t\tProprietaire(s) du compte : ");
                for(Client cl : c.getClients()){
                    System.out.println("\t\tClient avec l'id : "+cl.getId()+" nom : "+cl.getName()+" prenom : "+cl.getFirstName());
                }
            }
            System.out.println("######################");
        }
        em.close();
        emf.close();
    }
}
