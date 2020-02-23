package assignments.assignment1;

import java.lang.Math;
import java.util.Scanner;

public class HammingCode {

  static final int ENCODE_NUM = 1;
  static final int DECODE_NUM = 2;
  static final int EXIT_NUM = 3;

  /**
   * Encode a message into hamming code.
   *
   * @param data which is a hamming code that needs to be encoded
   * @return String which is the decoding hamming code message
   */
  public static String encode(String data) {

    // Finding r (redundant bit)
    int r = 1;
    int m = data.length();
    while (Math.pow(2, r) < (m + r + 1)) {
      r += 1;
    }

    // Placing redundant bits (r) in the array with the letter 'x'
    char[] encoded = new char[r + m];
    int parityCounter = 0;
    int dataCounter = 0;
    for (int i = 0; i < (r + m); i++) {
      if ((i + 1) == (int) Math.pow(2, parityCounter)) {
        encoded[i] = 'x';
        parityCounter++;
      } else {
        encoded[i] = data.charAt(dataCounter);
        dataCounter++;
      }
    }

    // Calculate the value of each redundant bits (r)
    // Loop each parity bits
    for (int i = 1; i < (r + m); i *= 2) {
      int temp = 0;
      int counter = i;
      int status = 1;
      //For each parity bits, count the bits accordingly
      // For parity 1, check 1, skip 1, ...
      // For parity 2, check 2, skip 2, ...
      // Repeat for all parity bits
      // The use of temp to hold the bits value, to be calculated for determining the actual value
      // of parity bits
      // Counter variable will keep track on the number of bits that needs to be check and skipped,
      // the status is used to determined if the bit should be checked of skipped
      for (int j = (i - 1); j < (r + m); j++) {
        if (encoded[j] == 'x' && counter == i) {
          counter--;
        } else if (counter > 0 && status == 1) {
          temp += Character.getNumericValue(encoded[j]);
          counter--;
        } else if (counter == 0 && status == 1) {
          status = 0;
          counter++;
        } else if (counter == i && status == 0) {
          temp += Character.getNumericValue(encoded[j]);
          counter--;
          status = 1;
        } else {
          counter++;
        }
      }
      if (temp % 2 == 0) {
        encoded[i - 1] = '0';
      } else {
        encoded[i - 1] = '1';
      }
    }

    StringBuilder result = new StringBuilder();
    for (char a : encoded) {
      result.append(a);
    }
    return result.toString();
  }

  /**
   * Decode hamming code message as well as fix any parity issue.
   *
   * @param code which is a hamming code message that needs to be encoded
   * @return String which is the decoded hamming code message
   */
  public static String decode(String code) {
    // The wrongBit is used to hold the parity bits that are wrong
    int wrongBit = 0;
    // The logic used in the decode function is similiar to encode, the difference is that, there
    // is no need for skipping the 'x' value.
    for (int i = 1; i < code.length(); i *= 2) {
      int temp = 0;
      int counter = i;
      int status = 1;
      for (int j = (i - 1); j < code.length(); j++) {
        if (counter > 0 && status == 1) {
          temp += Character.getNumericValue(code.charAt(j));
          counter--;
        } else if (counter == 0 && status == 1) {
          status = 0;
          counter++;
        } else if (counter == i && status == 0) {
          temp += Character.getNumericValue(code.charAt(j));
          counter--;
          status = 1;
        } else {
          counter++;
        }
      }
      if (temp % 2 != 0) {
        wrongBit += i;
      }
    }
    // If there are no wrongBit then there is no need to replace the wrong bit with the true value,
    // in case of there is a wrong bit, the bit value is switched using xor operation.
    String correct;
    if (wrongBit == 0) {
      correct = code;
    } else {
      correct =
          code.substring(0, wrongBit - 1) + Character.toString(code.charAt(wrongBit - 1) ^ 1) + code
              .substring(wrongBit);
    }
    StringBuilder result = new StringBuilder();
    int a = 0;
    for (int i = 0; i < correct.length(); i++) {
      if ((i + 1) % (int) Math.pow(2, a) == 0) {
        a++;
      } else {
        result.append(correct.charAt(i));
      }
    }
    return result.toString();
  }

  /**
   * Main program for Hamming Code.
   *
   * @param args unused
   */
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
