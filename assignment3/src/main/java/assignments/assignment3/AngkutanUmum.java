package assignments.assignment3;

public class AngkutanUmum extends Benda {
    // TODO: Implementasikan abstract method yang terdapat pada class Benda

    public AngkutanUmum(String name) {
        // TODO: Buat constructor untuk AngkutanUmum.
        // Hint: Akses constructor superclass-nya
        super(name);
    }

    @Override
    public void tambahPersentase() {
        // TODO Auto-generated method stub
        this.setPersentaseMenular(this.getPersentaseMenular() + 35);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("ANGKUTAN UMUM %s", this.getNama());
    }
}