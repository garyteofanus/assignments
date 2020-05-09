package assignments.assignment3;

public class Pintu extends Benda{
    // TODO: Implementasikan abstract method yang terdapat pada class Benda  
    
    public Pintu(String name){
        // TODO: Implementasikan apabila objek CleaningService ini membersihkan benda
        // Hint: Update nilai atribut jumlahDibersihkan
        super(name);
    }

    @Override
    public void tambahPersentase() {
        // TODO Auto-generated method stub
        this.setPersentaseMenular(this.getPersentaseMenular() + 30);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("PINTU %s", this.getNama());
    }
}