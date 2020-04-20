package assignments.assignment3;

public abstract class Manusia extends Carrier{
    private static int jumlahSembuh = 0;
    
    public Manusia(String nama){
        // TODO: Buat constructor untuk Manusia.
        // Hint: Akses constructor superclass-nya
    }
    
    public void tambahSembuh(){
        // TODO: Fungsi untuk menambahkan nilai pada atribut jumlahSembuh.
        // Hint: Perhatikan bahwa access modifiernya bertipe public
    }

    public static int getJumlahSembuh() {
        // TODO: Kembalikan nilai untuk atribut jumlahSembuh.
    }
    
}