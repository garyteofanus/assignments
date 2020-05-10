package assignments.assignment3;

public class TombolLift extends Benda {
    
    /**
     * Constructor for class TombolLift.
     * @param name TombolLift object name
     */
    public TombolLift(String name) {
        super(name);
    }

    /**
     * Add 20 to persentaseMenular each time instance of this class 
     * is interacting with instance of class Manusia.
     */
    @Override
    public void tambahPersentase() {
        this.setPersentaseMenular(this.getPersentaseMenular() + 20);
    }

    @Override
    public String toString() {
        return String.format("TOMBOL LIFT %s", this.getNama());
    }
}