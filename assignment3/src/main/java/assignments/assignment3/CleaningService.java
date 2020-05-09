package assignments.assignment3;

public class CleaningService extends Manusia{
  		
    private int jumlahDibersihkan;

    public CleaningService(String nama){
        // TODO: Buat constructor untuk CleaningService.
        // Hint: Akses constructor superclass-nya
        super(nama);
    }

    public void bersihkan(Benda benda){
        // TODO: Implementasikan apabila objek CleaningService ini membersihkan benda
        // Hint: Update nilai atribut jumlahDibersihkan
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

    public int getJumlahDibersihkan(){
        // TODO: Kembalikan nilai dari atribut jumlahDibersihkan
        return this.jumlahDibersihkan;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("CLEANING SERVICE %s", this.getNama());
    }

}