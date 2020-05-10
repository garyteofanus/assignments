package assignments.assignment3;

public class PekerjaJasa extends Manusia {

    /**
     * Constructor for class PekerjaJasa.
     * @param nama Object PekerjaJasa name
     */
    public PekerjaJasa(String nama) {
        super(nama);
    }

    @Override
    public String toString() {
        return String.format("PEKERJA JASA %s", this.getNama());
    }

}