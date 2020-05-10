package assignments.assignment3;

public class AngkutanUmum extends Benda {

    /**
     * Constructor for class AngkutanUmum.
     * @param name Object AngkutanUmum name
     */
    public AngkutanUmum(String name) {
        super(name);
    }

    @Override
    public void tambahPersentase() {
        this.setPersentaseMenular(this.getPersentaseMenular() + 35);
    }

    @Override
    public String toString() {
        return String.format("ANGKUTAN UMUM %s", this.getNama());
    }
}