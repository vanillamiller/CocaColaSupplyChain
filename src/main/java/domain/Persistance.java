package domain;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Persistance {
    public static List<DC> dcs;
    public static List<DC> getAllDCs(){
        if (dcs == null) {
            dcs = new LinkedList<DC>();
            dcs.add(new DC(0,"Melbourne",0,0));
            dcs.add(new DC(1,"Sydney",1,1));
            dcs.add(new DC(2,"Brisbane",2,2));
        }
        return dcs;
    }
    public static DC getDC(String name) {
        for (DC b: getAllDCs()) {
            if (b.getname().equals(name)) {
                return b;
            }
        }
        return null;
    }

    public static List<Retailer> retailers;
    public static List<Retailer> getAllretailers(){
        if (retailers == null) {
            retailers = new LinkedList<Retailer>();
            retailers.add(new Retailer(0,"ColesMelbourne",0));
            retailers.add(new Retailer(1,"ColesSydney",1));
            retailers.add(new Retailer(2,"ColesBrisbane",2));
            retailers.add(new Retailer(3,"ColesMelbourne2",3));
        }
        return retailers;
    }
    public static Retailer getretailer(String name) {
        for (Retailer b: getAllretailers()) {
            if (b.getname().equals(name)) {
                return b;
            }
        }
        return null;
    }

    public static List<Pallet> pallets;
    public static List<Pallet> getAllPallets(){
        if (pallets == null) {
            pallets = new LinkedList<Pallet>();
            Date date = new Date();
            pallets.add(new Pallet(0, date, "regular"));
            pallets.add(new Pallet(1, date, "vanilla"));
            pallets.add(new Pallet(2, date, "regular"));
        }
        return pallets;
    }
    public static Pallet makePallet(Integer DCId) {
        //        TODO when makePallet is called, need to auto increment pallet ID.
        Date date = new Date();
        pallets.add(new Pallet(2, date, "regular"));
        return null;
    }


    public static List<Transaction> transactions;
    public static List<Transaction> getAllTransactions(){
        if (transactions == null) {
            transactions = new LinkedList<Transaction>();
            Date date = new Date();
            transactions.add(new Transaction(1,date,1,1));
            transactions.add(new Transaction(1,date,2,2));
            transactions.add(new Transaction(1,date,3,3));
        }
        return transactions;
    }
    public static Transaction makeTransaction() {
        //        TODO when makeTransaction is called, need to auto increment transaction ID.
        Date date = new Date();
        transactions.add(new Transaction(1,date,4,4));
        return null;
    }
}