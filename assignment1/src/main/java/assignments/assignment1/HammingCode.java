package assignments.assignment1;

import java.util.Scanner;

public class HammingCode {
    static final int ENCODE_NUM = 1;
    static final int DECODE_NUM = 2;
    static final int EXIT_NUM = 3;

    public static String encode(String data) {
        return "TODO";
    }

    public static String decode(String code) {
        return "TODO";
    }

    public static void main(String[] args) {
        System.out.println("Selamat datang di program Hamming Code!");
        System.out.println("=======================================");
        Scanner in = new Scanner(System.in);
        boolean hasChosenExit = false;
        while (!hasChosenExit) {
            System.out.println();
            System.out.println("Pilih operasi:");
            System.out.println("1. Encode");
            System.out.println("2. Decode");
            System.out.println("3. Exit");
            System.out.println("Masukkan nomor operasi yang diinginkan: ");
            int operation = in.nextInt();
            if (operation == ENCODE_NUM) {
                System.out.println("Masukkan data: ");
                String data = in.next();
                String code = encode(data);
                System.out.println("Code dari data tersebut adalah: " + code);
            } else if (operation == DECODE_NUM) {
                System.out.println("Masukkan code: ");
                String code = in.next();
                String data = decode(code);
                System.out.println("Data dari code tersebut adalah: " + data);
            } else if (operation == EXIT_NUM) {
                System.out.println("Sampai jumpa!");
                hasChosenExit = true;
            }
        }
        in.close();
    }
}
