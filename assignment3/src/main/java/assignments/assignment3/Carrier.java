package assignments.assignment3;

import java.util.ArrayList;

public abstract class Carrier{

    private String nama;
    private String tipe;
    private Status statusCovid;
    private int aktifKasusDisebabkan;
    private int totalKasusDisebabkan;
    private ArrayList<Carrier> rantaiPenular;
    
    public Carrier(String nama,String tipe){
        // TODO: Buat constructor untuk Carrier.
    }

    public String getNama(){
        // TODO : Kembalikan nilai dari atribut nama
        return "";
    }
    
    public String getTipe(){
        // TODO : Kembalikan nilai dari atribut tipe
        return "";
    }
    
    public String getStatusCovid(){
        // TODO : Kembalikan nilai dari atribut statusCovid
        return "";
    }
    
    public int getAktifKasusDisebabkan(){
        // TODO : Kembalikan nilai dari atribut aktifKasusDisebabkan
        return 0;
    }
  
    public int getTotalKasusDisebabkan(){
        // TODO : Kembalikan nilai dari atribut totalKasusDisebabkan
        return 0;
    }

    public ArrayList<Carrier> getRantaiPenular(){
        // TODO : Kembalikan nilai dari atribut rantaiPenular
        return new ArrayList<>();
    }

    public void ubahStatus(String status){
        // TODO : Implementasikan fungsi ini untuk mengubah atribut dari statusCovid
    }
    
    public void interaksi(Carrier lain){
        // TODO : Objek ini berinteraksi dengan objek lain
    }
    
    public abstract String toString();
    
}