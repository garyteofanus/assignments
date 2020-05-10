package assignments.assignment3;

public class Pintu extends Benda {
    
    /**
     * Constructor for class Pintu.
     * @param name Object Pintu name
     */
    public Pintu(String name) {
        super(name);
    }

    @Override
    public void tambahPersentase() {
        this.setPersentaseMenular(this.getPersentaseMenular() + 30);
    }

    @Override
    public String toString() {
        return String.format("PINTU %s", this.getNama());
    }
}