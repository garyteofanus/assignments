package assignments.assignment3;

public class PetugasMedis extends Manusia{
  		
    private int jumlahDisembuhkan;

    public PetugasMedis(String nama){
        // TODO: Buat constructor untuk Jurnalis.
        // Hint: Akses constructor superclass-nya
        super(nama);
    }

    public void obati(Manusia manusia) {
        // TODO: Implementasikan apabila objek PetugasMedis ini menyembuhkan manusia
        // Hint: Update nilai atribut jumlahDisembuhkan
        manusia.ubahStatus("Negatif");
        this.jumlahDisembuhkan++;
        this.tambahSembuh();
        for (Carrier carrier : manusia.getRantaiPenular()) {
            carrier.setAktifKasusDisebabkan(carrier.getAktifKasusDisebabkan() - 1);
        }
        manusia.getRantaiPenular().clear();
    }

    public int getJumlahDisembuhkan(){
        // TODO: Kembalikan nilai dari atribut jumlahDisembuhkan
        return this.jumlahDisembuhkan;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("PETUGAS MEDIS %s", this.getNama());
    }
}