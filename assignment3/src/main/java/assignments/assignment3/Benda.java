package assignments.assignment3;

public abstract class Benda extends Carrier {

    protected int persentaseMenular;

    /**
     * Constructor for Class Benda.
     * @param name name for Benda object
     */
    public Benda(String name) {
        super(name, "Benda");
    }

    public abstract void tambahPersentase();

    public int getPersentaseMenular() {
        return this.persentaseMenular;
    }

    public void setPersentaseMenular(int persentase) {
        this.persentaseMenular = persentase;
    }
}