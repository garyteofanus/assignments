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

    /**
     * Constructor for class Carrier.
     * @param nama Object Carrier name
     * @param tipe Object Carrier type
     */
    public Carrier(String nama, String tipe) {
        this.nama = nama;
        this.tipe = tipe;
        this.rantaiPenular = new ArrayList<>();
        this.statusCovid = new Negatif();
        this.aktifKasusDisebabkan = 0;
        this.totalKasusDisebabkan = 0;
    }

    public String getNama() {
        return this.nama;
    }

    public String getTipe() {
        return this.tipe;
    }

    public String getStatusCovid() {
        return this.statusCovid.getStatus();
    }

    public int getAktifKasusDisebabkan() {
        return this.aktifKasusDisebabkan;
    }

    public int getTotalKasusDisebabkan() {
        return this.totalKasusDisebabkan;
    }

    public List<Carrier> getRantaiPenular() {
        return this.rantaiPenular;
    }

    public void setAktifKasusDisebabkan(int aktifKasusDisebabkan) {
        this.aktifKasusDisebabkan = aktifKasusDisebabkan;
    }

    /**
     * Change status to given one.
     * @param status new given status
     */
    public void ubahStatus(String status) {
        if (status.equalsIgnoreCase("Positif")) {
            this.statusCovid = new Positif();
        } else if (status.equalsIgnoreCase("Negatif")) {
            this.statusCovid = new Negatif();
        }
    }

    /**
     * Interact with other carrier. Make sure that both object are not instance of class Benda
     * @param lain Other Carrier object to interact with
     */
    public void interaksi(Carrier lain) {
        if (!this.getTipe().equals("Benda") || !lain.getTipe().equalsIgnoreCase("Benda")) {
            new Positif().tularkan(this, lain);

            if (this.getStatusCovid().equalsIgnoreCase("Positif")
                && lain.getStatusCovid().equalsIgnoreCase("Positif")) {
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

    /**
     * Implement toStrig according to specification for each child.
     */
    public abstract String toString();

}
