// Anirudh Prakash
// from December 2017

import java.util.*;

// Program to encode or decode using Caesar cipher
public class CaesarCipher {
   public static final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
   public static final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
            
      System.out.println("This is a Caesar cipher. It is a code that");
      System.out.println("shifts the letters by a certain amount in the");
      System.out.println("alphabet. Would you like to encode or decode?");
      
      String choice;
      do {      
         System.out.print("(E)ncode, (D)ecode, or (Q)uit? ");
         choice = console.next();
         System.out.println();
      
         if (choice.equalsIgnoreCase("E")) {
            encode(console); // some issue that it repeats the menu twice only after encoding
         } else if (choice.equalsIgnoreCase("D")) {
            decode(console);
         }
      } while (!choice.equalsIgnoreCase("Q"));
   }
   
   public static void encode(Scanner console) {
      System.out.print("Enter a word or phrase to be encoded: ");
      String phrase = console.next();
      System.out.print("Enter the shift number (1-25): ");
      int shift = console.nextInt();
      System.out.println();
      
      String encoded = "";
      for (int i = 0; i < phrase.length(); i++) {
         String oldEncoded = encoded;
         String phraseChar = phrase.substring(i, i + 1);
         for (int j = 0; j < 26; j++) {
            String lowAlphabet = lowerCase.substring(j, j + 1);
            String upAlphabet = upperCase.substring(j, j + 1);
            int shifted = j + shift;
            shifted = shifted % 26;
            if (phraseChar.equals(lowAlphabet)) {
               encoded += lowerCase.substring(shifted, shifted + 1);
            } else if (phraseChar.equals(upAlphabet)) {
               encoded += upperCase.substring(shifted, shifted + 1);
            }
         }
         // if the character is not a letter, print that character
         if (encoded.equals(oldEncoded)) {
            encoded += phraseChar;
         }
      }
      System.out.println("Here is your encoded phrase:");
      System.out.println(encoded);
      System.out.println();
   }
   
   public static void decode(Scanner console) {
      System.out.print("Enter a word or phrase to be decoded: ");
      String phrase = console.next();
      System.out.println();
      System.out.println("Here are all the possibilities:");
      System.out.println("(Shift # is a shift on encoded message, not on original:");
      System.out.println(" a Shift of 1 means an original shift of 25;");
      System.out.println(" a Shift of N means an original shift of [26-N]).");
      
      for (int shift = 1; shift <= 25; shift++) {
         String decoded = "";
         for (int i = 0; i < phrase.length(); i++) {
            String oldDecoded = decoded;
            String phraseChar = phrase.substring(i, i + 1);
            for (int j = 0; j < 26; j++) {
               String lowAlphabet = lowerCase.substring(j, j + 1);
               String upAlphabet = upperCase.substring(j, j + 1);
               int shifted = j + shift;
               shifted = shifted % 26;
               if (phraseChar.equals(lowAlphabet)) {
                  decoded += lowerCase.substring(shifted, shifted + 1);
               } else if (phraseChar.equals(upAlphabet)) {
                  decoded += upperCase.substring(shifted, shifted + 1);
               }
            }
            // if the character is not a letter, print that character
            if (decoded.equals(oldDecoded)) {
               decoded += phraseChar;
            }
         }
         System.out.println("Shift of " + shift + ": " + decoded);
      }
      System.out.println();
   }
}