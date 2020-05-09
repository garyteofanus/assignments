package assignments.assignment3;

public class Positif implements Status{
  
    public String getStatus(){
        return "Positif";
    }

    public void tularkan(Carrier penular, Carrier tertular){
        // TODO: Implementasikan apabila object Penular melakukan interaksi dengan object tertular
        // Hint: Handle kasus ketika keduanya benda dapat dilakukan disini
        if (penular.getTipe().equalsIgnoreCase("Manusia") && tertular.getTipe().equalsIgnoreCase("Manusia")) {
            tertular.ubahStatus("Positif");
        } else if (penular.getTipe().equalsIgnoreCase("Manusia") && tertular.getTipe().equalsIgnoreCase("Benda")) {
            ((Benda) tertular).tambahPersentase();
            if (((Benda) tertular).getPersentaseMenular() >= 100) {
                tertular.ubahStatus("Positif");
            }
        } else if (penular.getTipe().equalsIgnoreCase("Benda") && tertular.getTipe().equalsIgnoreCase("Manusia")) {
            tertular.ubahStatus("Positif");
        }
    }
}