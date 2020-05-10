package assignments.assignment3;

public class Ojol extends Manusia {

    /**
     * Constructor for class Ojol.
     * @param name Object Ojol name
     */
    public Ojol(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("OJOL %s", this.getNama());
    }

}