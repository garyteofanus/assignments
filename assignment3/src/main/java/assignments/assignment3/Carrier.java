package assignments.assignment3;

import java.util.ArrayList;
import java.util.List;

public abstract class Carrier {

    private String nama;
    private String tipe;
    private Status statusCovid;
    private int aktifKasusDisebabkan;
    private int totalKasusDisebabkan;
    private List<Carrier> rantaiPenular;

    public Carrier(String nama, String tipe) {
        // TODO: Buat constructor untuk Carrier.
        this.nama = nama;
        this.tipe = tipe;
        this.rantaiPenular = new ArrayList<>();
        this.statusCovid = new Negatif();
        this.aktifKasusDisebabkan = 0;
        this.totalKasusDisebabkan = 0;
    }

    public String getNama() {
        // TODO : Kembalikan nilai dari atribut nama
        return this.nama;
    }

    public String getTipe() {
        // TODO : Kembalikan nilai dari atribut tipe
        return this.tipe;
    }

    public String getStatusCovid() {
        // TODO : Kembalikan nilai dari atribut statusCovid
        return this.statusCovid.getStatus();
    }

    public int getAktifKasusDisebabkan() {
        // TODO : Kembalikan nilai dari atribut aktifKasusDisebabkan
        return this.aktifKasusDisebabkan;
    }

    public int getTotalKasusDisebabkan() {
        // TODO : Kembalikan nilai dari atribut totalKasusDisebabkan
        return this.totalKasusDisebabkan;
    }

    public List<Carrier> getRantaiPenular() {
        // TODO : Kembalikan nilai dari atribut rantaiPenular
        return this.rantaiPenular;
    }

    /**
     * @param aktifKasusDisebabkan the aktifKasusDisebabkan to set
     */
    public void setAktifKasusDisebabkan(int aktifKasusDisebabkan) {
        this.aktifKasusDisebabkan = aktifKasusDisebabkan;
    }

    public void ubahStatus(String status) {
        // TODO : Implementasikan fungsi ini untuk mengubah atribut dari statusCovid
        if (status.equalsIgnoreCase("Positif")) {
            this.statusCovid = new Positif();
        } else if (status.equalsIgnoreCase("Negatif")) {
            this.statusCovid = new Negatif();
        }
    }

    public void interaksi(Carrier lain) {
        // TODO : Objek ini berinteraksi dengan objek lain
        if (!this.getTipe().equals("Benda") || !lain.getTipe().equalsIgnoreCase("Benda")) {
            new Positif().tularkan(this, lain);

            if (this.getStatusCovid().equalsIgnoreCase("Positif") && lain.getStatusCovid().equalsIgnoreCase("Positif")) {
                if (this.getRantaiPenular().size() != 0) {
                    for (Carrier carrier : this.getRantaiPenular()) {
                        lain.getRantaiPenular().add(carrier);
                        if (carrier != lain) {
                            carrier.totalKasusDisebabkan++;
                            carrier.aktifKasusDisebabkan++;
                        }
                    }
                }

                lain.getRantaiPenular().add(this);
                this.totalKasusDisebabkan++;
                this.aktifKasusDisebabkan++;
            }
        }
    }

    public abstract String toString();

}
