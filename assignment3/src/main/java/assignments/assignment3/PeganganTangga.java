package assignments.assignment3;

public class PeganganTangga extends Benda{
    // TODO: Implementasikan abstract method yang terdapat pada class Benda
  	
    public PeganganTangga(String name){
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
        return String.format("PEGANGAN TANGGA %s", this.getNama());
    }
    
}