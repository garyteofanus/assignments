package assignments.assignment3;

import java.util.Scanner;

public class Simulator {

    /**
     * Main class for assignment 3, greet user, ask for inputType, run the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFile = "NOTHING";
        String outputFile = "NOTHING";
        System.out.println("Selamat datang di program simulasi COVID-19!");
        
        System.out.println("Silahkan masukkan metode input "
            + "yang anda inginkan (TEXT/TERMINAL/GUI):");
        String inputType = scanner.nextLine();
        if (inputType.equalsIgnoreCase("text")) {
            inputFile = scanner.nextLine();
        } else if (inputType.equalsIgnoreCase("gui")) {
            SimulatorGUI.main(args);
        }
        
        System.out.println("Silahkan masukkan metode output "
            + "yang anda inginkan (TEXT/TERMINAL):");
        String outputType = scanner.nextLine();
        if (outputType.equalsIgnoreCase("text")) {
            outputFile = scanner.nextLine();
        }
        
        InputOutput io = new InputOutput(inputType, inputFile, outputType, outputFile);
        try {
            io.run();
        } catch (Exception e) { 
            e.printStackTrace();
        }
        scanner.close();
    }
}