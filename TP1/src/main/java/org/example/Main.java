package org.example;

import org.example.model.Produit;
import org.example.services.ProduitService;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        ProduitService ps = new ProduitService();
        ps.begin();
        ps.create(new Produit("Peugeot", "5008", new Date("2020/12/02"), 15000.50, 3));
        ps.create(new Produit("Renault", "Clio", new Date("2022/11/03"), 8000.50, 2));
        ps.create(new Produit("Audi", "A3", new Date("2022/12/08"), 12000.50, 1));
        ps.create(new Produit("Fiat", "500", new Date("2022/12/12"), 5000.50, 3));
        ps.create(new Produit("Seat", "Leon", new Date("2020/12/02"), 7000.50, 3));
        ps.create(new Produit("Peugeot", "208", new Date("2022/09/05"), 11000.50, 5));
        ps.create(new Produit("Peugeot", "308", new Date("2022/11/03"), 12000.50, 4));
        ps.create(new Produit("Audi", "A4", new Date("2022/11/08"), 18000.50, 1));
        ps.create(new Produit("Renault", "Espace", new Date("2021/12/11"), 15500.50, 2));
        ps.create(new Produit("Seat", "Ibiza", new Date("2020/08/02"), 7000.50, 1));
        ps.envoie();

        ps.begin();
        Produit p = ps.findById(2);
        ps.envoie();

        ps.begin();
        ps.delete(ps.findById(3));
        ps.envoie();

        ps.begin();
        p = ps.findById(1);
        if(p != null) {
            p.setPrix(12000.00);
            ps.update(p);
        }
        ps.envoie();

        ps.begin();
        System.out.println("2.1");
        for(Produit produit : ps.findAll()){
            System.out.println("marque : " + produit.getMarque() + ", référence : " + produit.getReference() + ", prix : " + produit.getPrix() + ", stock : " + produit.getStock() + ", date d'achat : " + produit.getDateAchat());
        }
        ps.envoie();

        ps.begin();
        System.out.println("2.2");
        for(Produit prod : ps.selectByPrice(8000.00)){
            System.out.println("marque : " + prod.getMarque() + ", référence : " + prod.getReference() + ", prix : " + prod.getPrix());
        }
        ps.envoie();

        ps.begin();
        System.out.println("2.3");
        String madate1 ="02/12/2020";
        Date date1= new SimpleDateFormat("dd/MM/yyyy").parse(madate1);
        String madate2="03/11/2022";
        Date date2= new SimpleDateFormat("dd/MM/yyyy").parse(madate2);
        List<Produit> produitsdate = ps.selectBetweenDate(date1,date2);
        for(Produit pr :  produitsdate) {
            System.out.println(pr.getId() + " , " + pr.getMarque() + " , " + pr.getReference() + " , " + pr.getDateAchat() + " , " + pr.getPrix());
        }
        ps.envoie();

        ps.begin();
        System.out.println("3.1");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir la date de début : ");
        String saisie1 = scanner.nextLine();
        Date date3= new SimpleDateFormat("dd/MM/yyyy").parse(saisie1);
        System.out.println("Saisir la date de début : ");
        String saisie2 = scanner.nextLine();
        Date date4= new SimpleDateFormat("dd/MM/yyyy").parse(saisie2);
        List<Produit> produitsdat = ps.selectBetweenDate(date3,date4);
        for(Produit pr :  produitsdat) {
            System.out.println(pr.getId() + " , " + pr.getMarque() + " , " + pr.getReference() + " , " + pr.getDateAchat() + " , " + pr.getPrix());
        }
        ps.envoie();

        System.out.println("3.2");
        ps.begin();
        System.out.println("Saisir la marque recherchée : ");
        String input = scanner.nextLine();
        System.out.println("Total " +  input + " : " +  ps.sumByMarque(input) + "€.");
        ps.envoie();

        System.out.println("3.2 /// option");
        ps.begin();
        Scanner scan = new Scanner(System.in);
        System.out.println("Saisir la marque recherchée : ");
        String saisie = scan.next();
        for(Produit produit : ps.selectByMarque(saisie)){
            System.out.println("marque : " + produit.getMarque() + ", référence : " + produit.getReference() + ", prix : " + produit.getPrix());
        }
        ps.envoie();

        ps.close();
    }
}