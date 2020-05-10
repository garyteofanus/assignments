package assignments.assignment3;

public class PeganganTangga extends Benda {

    /**
     * Constructor for class PeganganTangga.
     * @param name Object PeganganTangga name.
     */
    public PeganganTangga(String name) {
        super(name);
    }

    @Override
    public void tambahPersentase() {
        this.setPersentaseMenular(this.getPersentaseMenular() + 20);
    }

    @Override
    public String toString() {
        return String.format("PEGANGAN TANGGA %s", this.getNama());
    }
    
}