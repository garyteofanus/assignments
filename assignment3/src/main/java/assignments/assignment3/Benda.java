package assignments.assignment3;


public abstract class Benda extends Carrier{
  
    protected int persentaseMenular;

    public Benda(String name){
        // TODO: Buat constructor untuk Benda.
        // Hint: Akses constructor superclass-nya
    }

    public abstract void tambahPersentase();

    public int getPersentaseMenular(){
        // TODO : Kembalikan nilai dari atribut persentaseMenular
        return 0;
    }
    
    public void setPersentaseMenular(int persentase) {
        // TODO : Gunakan sebagai setter untuk atribut persentase menular
    }
}