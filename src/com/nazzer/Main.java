package com.nazzer;

public class Main {

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase();

    public static void main(String[] args) {
        String CipherString = cipher("guitar", "POLYALPHABETICCIPHER");

        String DecipherString = decipher("guitar", CipherString);

        System.out.println("Key - guitar");
        System.out.println("Cipher - " + CipherString);
        System.out.println("Decipher - " + DecipherString);
    }

    public static String cipher (String key, String string) {
        key = key.toUpperCase();
        string = string.toUpperCase();
        int currentIndex = 0;
        String encrypted = "";
        for(int i = 0; i < string.length(); i++) {
            if(currentIndex == key.length()) {
                currentIndex = 0;
            }

            int rowIndex = alphabet.indexOf(string.charAt(i));
            String interceptValue = alphabet.substring(rowIndex, alphabet.length()) + alphabet.substring(0, rowIndex);
            int columnIndex = alphabet.indexOf(key.charAt(currentIndex));
            encrypted += interceptValue.charAt(columnIndex);
            currentIndex++;
        }
        return encrypted;
    }

    public static String decipher(String key, String string) {
        key = key.toUpperCase();
        string = string.toUpperCase();
        int currentIndex = 0;
        String decrypted = "";
        for(int i = 0; i < string.length(); i++) {
            if(currentIndex == key.length()) {
                currentIndex = 0;
            }
            // Get the current column based on key character
            int columnIndex = alphabet.indexOf(key.charAt(currentIndex));

            // Split up the original alphabet and append it to the end of the separated string
            String interceptValue = alphabet.substring(columnIndex, alphabet.length()) + alphabet.substring(0, columnIndex);

            // Get Current Character index from modified alphabet
            int rowIndex = interceptValue.indexOf(string.charAt(i));

            decrypted += alphabet.charAt(rowIndex);

            // Increment index based on string value
            currentIndex++;
        }

        // Display the deciphered value to the user
        return decrypted;
    }
}
