package assignments.assignment3;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class InputOutput {

    private BufferedReader br;
    private PrintWriter pw;
    private String inputFile;
    private String outputFile;
    private World world;

    public InputOutput(String inputType, String inputFile, String outputType, String outputFile) {
        // TODO: Buat constructor untuk InputOutput.
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        try {
            setBufferedReader(inputType);
            setPrintWriter(outputType);
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("File is not found");
        }
    }

    public void setBufferedReader(String inputType) throws IOException {
        // TODO: Membuat BufferedReader bergantung inputType (I/O text atau input
        // terminal)
        if (inputType.equalsIgnoreCase("TEXT")) {
            this.br = new BufferedReader(new FileReader(this.inputFile));
        } else if (inputType.equalsIgnoreCase("TERMINAL")) {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }
    }

    public void setPrintWriter(String outputType) throws IOException {
        // TODO: Membuat PrintWriter bergantung inputType (I/O text atau output
        // terminal)
        if (outputType.equalsIgnoreCase("TEXT")) {
            this.pw = new PrintWriter(new FileWriter(this.outputFile));
        } else if (outputType.equals("TERMINAL")) {
            this.pw = new PrintWriter(new OutputStreamWriter(System.out));
        }
    }

    public void run() throws IOException {
        // TODO: Program utama untuk InputOutput, jangan lupa handle untuk IOException
        // Hint: Buatlah objek dengan class World
        // Hint: Untuk membuat object Carrier baru dapat gunakan method CreateObject
        // pada class World
        // Hint: Untuk mengambil object Carrier dengan nama yang sesua dapat gunakan
        // method getCarrier pada class World
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
                            throw new BelumTertularException(String.format("%s berstatus negatif", obj1.toString()));
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
                    pw.println(String.format("%s telah menyebarkan virus COVID ke %d objek", obj1.toString(),
                            obj1.getTotalKasusDisebabkan()));
                    continue;
                case "AKTIF_KASUS_DARI_OBJEK":
                    pw.println(String.format(
                            "%s telah menyebarkan virus COVID dan masih teridentifikasi positif sebanyak %d objek",
                            obj1.toString(), obj1.getAktifKasusDisebabkan()));
                    continue;
                case "TOTAL_SEMBUH_MANUSIA":
                    pw.println(
                            String.format("Total sembuh dari kasus COVID yang menimpa manusia ada sebanyak: %d kasus",
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
                default:
                    for (String string : input) {
                        pw.println(string);
                    }
                    pw.println("Query is invalid, exiting ...");
                    br.close();
                    pw.close();
                    System.exit(0);
            }
        }
    }
}