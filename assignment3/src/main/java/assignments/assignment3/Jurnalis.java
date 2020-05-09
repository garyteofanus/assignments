package assignments.assignment3;

public class Jurnalis extends Manusia {

    public Jurnalis(String name) {
        // TODO: Buat constructor untuk Jurnalis.
        // Hint: Akses constructor superclass-nya
        super(name);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("JURNALIS %s", this.getNama());
    }

}