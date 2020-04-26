package assignments.assignment3;

import java.util.ArrayList;
import java.util.List;

public abstract class Carrier{

    private String nama;
    private String tipe;
    private Status statusCovid;
    private int aktifKasusDisebabkan;
    private int totalKasusDisebabkan;
    private List<Carrier> rantaiPenular;

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

    public List<Carrier> getRantaiPenular(){
        // TODO : Kembalikan nilai dari atribut rantaiPenular
        return null;
    }

    public void ubahStatus(String status){
        // TODO : Implementasikan fungsi ini untuk mengubah atribut dari statusCovid
    }

    public void interaksi(Carrier lain){
        // TODO : Objek ini berinteraksi dengan objek lain
    }

    public abstract String toString();

}
