package assignments.assignment3;

import java.io.*;

public class InputOutput{
  	
    private BufferedReader br;
    private PrintWriter pw;
    private String inputFile;
    private String outputFile; 
    private World world;

    public InputOutput(String inputType, String inputFile, String outputType, String outputFile){
        // TODO: Buat constructor untuk InputOutput.
    }

    public void setBufferedReader(String inputType){
        // TODO: Membuat BufferedReader bergantung inputType (I/O text atau input terminal) 
    }
    
    public void setPrintWriter(String outputType){
        // TODO: Membuat PrintWriter bergantung inputType (I/O text atau output terminal) 
    }

    public void run() throws IOException{
        // TODO: Program utama untuk InputOutput, jangan lupa handle untuk IOException
        // Hint: Buatlah objek dengan class World
        // Hint: Untuk membuat object Carrier baru dapat gunakan method CreateObject pada class World
        // Hint: Untuk mengambil object Carrier dengan nama yang sesua dapat gunakan method getCarrier pada class World
    }
    
}