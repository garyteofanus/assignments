package assignments.assignment3;

public abstract class Manusia extends Carrier {

    private static int jumlahSembuh = 0;

    /**
     * Constructor for clas manusia.
     * @param nama Object Manusia name
     */
    public Manusia(String nama) {
        super(nama, "Manusia");
    }

    public void tambahSembuh() {
        Manusia.jumlahSembuh++;
    }

    public static int getJumlahSembuh() {
        return Manusia.jumlahSembuh;
    }

}