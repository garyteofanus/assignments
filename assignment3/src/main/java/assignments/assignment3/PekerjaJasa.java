package assignments.assignment3;

public class PekerjaJasa extends Manusia {

    public PekerjaJasa(String nama){
    	// TODO: Buat constructor untuk Jurnalis.
        // Hint: Akses constructor superclass-nya
        super(nama);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("PEKERJA JASA %s", this.getNama());
    }

}