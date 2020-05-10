package assignments.assignment3;

public class Positif implements Status {
  
    public String getStatus() {
        return "Positif";
    }

    /**
     * Infect other Carrier object, react relative to penular and tertular type.
     * @param penular Carrier object infecting (must be COVID Positive)
     * @param tertular Carrier object infected
     */
    public void tularkan(Carrier penular, Carrier tertular) {
        
        String tipePenular = penular.getTipe();
        String tipeTertular = tertular.getTipe();

        if (tipePenular.equalsIgnoreCase("Manusia") && tipeTertular.equalsIgnoreCase("Manusia")) {
            tertular.ubahStatus("Positif");
        } else if (tipePenular.equalsIgnoreCase("Manusia") 
            && tipeTertular.equalsIgnoreCase("Benda")) {
            ((Benda) tertular).tambahPersentase();
            if (((Benda) tertular).getPersentaseMenular() >= 100) {
                tertular.ubahStatus("Positif");
            }
        } else if (tipePenular.equalsIgnoreCase("Benda") 
            && tipeTertular.equalsIgnoreCase("Manusia")) {
            tertular.ubahStatus("Positif");
        }
    }
}