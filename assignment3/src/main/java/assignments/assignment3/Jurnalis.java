package assignments.assignment3;

public class Jurnalis extends Manusia {

    /**
     * Constructor for class Jurnalis.
     * @param name Object Jurnalis name
     */
    public Jurnalis(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format("JURNALIS %s", this.getNama());
    }

}