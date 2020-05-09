package assignments.assignment3;

public class TombolLift extends Benda{
      // TODO: Implementasikan abstract method yang terdapat pada class Benda
      
    public TombolLift(String name){
        // TODO: Buat constructor untuk Jurnalis.
        // Hint: Akses constructor superclass-nya
        super(name);
    }

    @Override
    public void tambahPersentase() {
        // TODO Auto-generated method stub
        this.setPersentaseMenular(this.getPersentaseMenular() + 20);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("TOMBOL LIFT %s", this.getNama());
    }
}