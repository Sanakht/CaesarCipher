package JavaRush.Module1.model;

import JavaRush.Module1.exceptions.NotFoundSymbolException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

        int keyFirstIndex = 0; // Значение индекса с которого будет происходить отсчет

        // Валидация ключа

        int encryptKey = key >= 0? key % alphabet.length + keyFirstIndex : (key % alphabet.length) + keyFirstIndex + alphabet.length;



        for(String text: listInputFile) {
            char[] arrayChar = text.toCharArray();

            char[] newArrayChar = new char[arrayChar.length];

            for (int i = 0; i < arrayChar.length; i++) {
                int j = 0;
                boolean indexJ = true;
                do{

                    if(arrayChar[i] == alphabet[j]) {
                        int index = j + encryptKey;
                        if(index > alphabet.length - 1 ) {
                            index = (index - alphabet.length) % alphabet.length;
                        }
                        newArrayChar[i] = alphabet[index];
                        indexJ = false;
                    }
                    j++;

                   if(j > alphabet.length - 1){
                       throw new NotFoundSymbolException(Character.toString(arrayChar[i]));
                    }

                }while(indexJ);
            }

            str.append(newArrayChar).append('\n');
        }

        Files.write(outputPath, str.toString().getBytes());

    }
    public void decrypt(String encryptedText, int shift) {
        // Логика расшифровки

    }

}
