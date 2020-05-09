package assignments.assignment3;

public class Ojol extends Manusia {

    public Ojol(String name) {
        // TODO: Buat constructor untuk Jurnalis.
        // Hint: Akses constructor superclass-nya
        super(name);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("OJOL %s", this.getNama());
    }

}