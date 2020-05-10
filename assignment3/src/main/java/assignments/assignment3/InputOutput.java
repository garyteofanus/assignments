package assignments.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class InputOutput {

    private BufferedReader br;
    private PrintWriter pw;
    private String inputFile;
    private String outputFile;
    private World world;

    /**
     * Constructor for InputOutput.
     * 
     * @param inputType  type for input (terminal or text)
     * @param inputFile  filename if inputType is text
     * @param outputType type for output (terminal or text)
     * @param outputFile filename if outputType is text
     */
    public InputOutput(String inputType, String inputFile, String outputType, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        try {
            setBufferedReader(inputType);
            setPrintWriter(outputType);
        } catch (FileNotFoundException e) {
            System.out.println("File is not found, exiting...");
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    /**
     * Set BufferedReader according to inputType.
     * 
     * @param inputType terminal or text
     * @throws IOException throws error if inputFile is not found
     */
    public void setBufferedReader(String inputType) throws IOException {
        if (inputType.equalsIgnoreCase("TEXT")) {
            this.br = new BufferedReader(new FileReader(this.inputFile));
        } else if (inputType.equalsIgnoreCase("TERMINAL")) {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        } else {
            throw new IOException("Invalid input type, exiting...");
        }
    }

    /**
     * Set PrintWriter accordng to outputType.
     * 
     * @param outputType terminal or text
     * @throws IOException throws error if outputFile is not found
     */
    public void setPrintWriter(String outputType) throws IOException {
        if (outputType.equalsIgnoreCase("TEXT")) {
            this.pw = new PrintWriter(new FileWriter(this.outputFile));
        } else if (outputType.equals("TERMINAL")) {
            this.pw = new PrintWriter(new OutputStreamWriter(System.out));
        } else {
            throw new IOException("Invalid output type, exiting...");
        }
    }

    /**
     * Check query from input (text or terminal) and process accordingly.
     * 
     * @throws IOException throw error from readLine()
     */
    public void run() throws IOException {
        this.world = new World();

        while (true) {
            String[] temp = br.readLine().split(" ");
            String[] input = new String[3];
            for (int i = 0; i < temp.length; i++) {
                input[i] = temp[i];
            }
            String query = input[0].toUpperCase();
            Carrier obj1 = world.getCarrier(input[1]);
            Carrier obj2 = world.getCarrier(input[2]);
            switch (query) {
                case "ADD":
                    world.listCarrier.add(world.createObject(input[1], input[2]));
                    continue;
                case "INTERAKSI":
                    if (obj1.getStatusCovid().equalsIgnoreCase("Positif")) {
                        obj1.interaksi(obj2);
                    } else if (obj2.getStatusCovid().equalsIgnoreCase("Positif")) {
                        obj2.interaksi(obj1);
                    }
                    continue;
                case "POSITIFKAN":
                    obj1.ubahStatus("Positif");
                    continue;
                case "SEMBUHKAN":
                    ((PetugasMedis) obj1).obati((Manusia) obj2);
                    continue;
                case "BERSIHKAN":
                    ((CleaningService) obj1).bersihkan((Benda) obj2);
                    continue;
                case "RANTAI":
                    try {
                        if (obj1.getStatusCovid().equalsIgnoreCase("Negatif")) {
                            throw new BelumTertularException(
                                String.format("%s berstatus negatif", obj1.toString()));
                        } else if (obj1.getStatusCovid().equalsIgnoreCase("Positif")) {
                            String ret = "Rantai penyebaran " + obj1.toString() + ": ";
                            if (obj1.getRantaiPenular().size() != 0) {
                                for (Carrier carrier : obj1.getRantaiPenular()) {
                                    ret += carrier.toString() + " -> ";
                                }
                            }
                            ret += obj1.toString();
                            pw.println(ret);
                        }
                    } catch (BelumTertularException e) {
                        pw.println(e);
                    }
                    continue;
                case "TOTAL_KASUS_DARI_OBJEK":
                    pw.println(
                        String.format("%s telah menyebarkan virus COVID ke %d objek",
                            obj1.toString(), obj1.getTotalKasusDisebabkan()));
                    continue;
                case "AKTIF_KASUS_DARI_OBJEK":
                    pw.println(String.format(
                            "%s telah menyebarkan virus COVID "
                            + "dan masih teridentifikasi positif sebanyak %d objek",
                            obj1.toString(), obj1.getAktifKasusDisebabkan()));
                    continue;
                case "TOTAL_SEMBUH_MANUSIA":
                    pw.println(String.format(
                            "Total sembuh dari kasus COVID "
                            + "yang menimpa manusia ada sebanyak: %d kasus",
                            Manusia.getJumlahSembuh()));
                    continue;
                case "TOTAL_SEMBUH_PETUGAS_MEDIS":
                    pw.println(String.format("%s menyembuhkan %d manusia", obj1.toString(),
                            ((PetugasMedis) obj1).getJumlahDisembuhkan()));
                    continue;
                case "TOTAL_BERSIH_CLEANING_SERVICE":
                    pw.println(String.format("%s membersihkan %d benda", obj1.toString(),
                            ((CleaningService) obj1).getJumlahDibersihkan()));
                    continue;
                case "EXIT":
                    br.close();
                    pw.close();
                    System.exit(0);
                    break;
                default:
                    pw.println("Invalid query, exiting...");
                    br.close();
                    pw.close();
                    System.exit(0);
            }
        }
    }
}