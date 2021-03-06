package assignments.assignment3;

public class PetugasMedis extends Manusia {

    private int jumlahDisembuhkan;

    /**
     * Constructor for class PetugasMedis.
     * @param nama Object PetugasMedis name
     */
    public PetugasMedis(String nama) {
        super(nama);
    }

    /**
     * Cure other human and subsequently do the following things for the patient:
     *      1. Reset rantaiPenular list
     *      2. Increase jumlahDisembuhkan for the medic
     *      3. Change patient COVID status to Negative
     *      4. Increase number of human healed
     *      5. Decrease aktifKasusDisebabkan on each Carrier in patient rantaiPenular
     */
    public void obati(Manusia manusia) {
        manusia.ubahStatus("Negatif");
        this.jumlahDisembuhkan++;
        this.tambahSembuh();
        for (Carrier carrier : manusia.getRantaiPenular()) {
            carrier.setAktifKasusDisebabkan(carrier.getAktifKasusDisebabkan() - 1);
        }
        manusia.getRantaiPenular().clear();
    }

    public int getJumlahDisembuhkan() {
        return this.jumlahDisembuhkan;
    }

    @Override
    public String toString() {
        return String.format("PETUGAS MEDIS %s", this.getNama());
    }
}