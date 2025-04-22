package JavaRush.Module1.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Cipher {

    private char[] alphabet;

    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public void encrypt(String inputFile, String outputFile, int key) throws IOException {
        StringBuilder str = new StringBuilder();

        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);

        List<String> listInputFile = Files.readAllLines(inputPath);

        for(String text: listInputFile) {
            char[] arrayChar = text.toCharArray();

            char[] newArrayChar = new char[arrayChar.length];

            for (int i = 0; i < arrayChar.length; i++) {
                for (int j = 0; j < alphabet.length; j++) {

                    if(arrayChar[i] == alphabet[j]) {
                        int index = j + key;
                        if(index > alphabet.length - 1 ) {
                            index = index - alphabet.length;
                            newArrayChar[i] = alphabet[index];
                        }
                        newArrayChar[i] = alphabet[index];
                    }
                }
            }

            str.append(newArrayChar).append("\n");
        }

        Files.write(outputPath, str.toString().getBytes());

    }
    public void decrypt(String encryptedText, int shift) {
        // Логика расшифровки

    }

}
