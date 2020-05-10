package assignments.assignment3;

public class CleaningService extends Manusia {

    private int jumlahDibersihkan;

    /**
     * Constructor for class CleaningService.
     * @param nama Object CleaningService name
     */
    public CleaningService(String nama) {
        super(nama);
    }

    /**
     * Clean other things by changing their status from Positive to Negative.
     * @param benda Object benda to be cleaned
     */
    public void bersihkan(Benda benda) {
        if (benda.getStatusCovid().equalsIgnoreCase("Negatif")) {
            benda.setPersentaseMenular(0);
        } else if (benda.getStatusCovid().equalsIgnoreCase("Positif")) {
            benda.setPersentaseMenular(0);
            benda.ubahStatus("Negatif");
        }
        this.jumlahDibersihkan++;
        for (Carrier carrier : benda.getRantaiPenular()) {
            if (carrier != benda) {
                carrier.setAktifKasusDisebabkan(carrier.getAktifKasusDisebabkan() - 1);
            }
        }
    }

    public int getJumlahDibersihkan() {
        return this.jumlahDibersihkan;
    }

    @Override
    public String toString() {
        return String.format("CLEANING SERVICE %s", this.getNama());
    }

}