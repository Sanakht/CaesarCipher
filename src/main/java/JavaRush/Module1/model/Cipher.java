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

    public void encrypt(String inputFile, String outputFile, int keyEncrypt, int keyStartIndexEncrypt) throws IOException {
        StringBuilder str = new StringBuilder();

        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);

        List<String> listInputFile = Files.readAllLines(inputPath); // Читаем все строки в файле inputPath и добавляем их построчно в коллекцию

        int keyFirstIndex = keyStartIndexEncrypt >= 0? keyStartIndexEncrypt % alphabet.length : keyStartIndexEncrypt % alphabet.length  + alphabet.length; // Значение индекса с которого будет происходить отсчет

        int encryptKey = keyEncrypt >= 0? keyEncrypt % alphabet.length + keyFirstIndex  : (keyEncrypt % alphabet.length) + keyFirstIndex  + alphabet.length; // Определяем по ключу, в каком направлении двигаться по массиву

        for(String text: listInputFile) { // Используем цикл for-each для прохода по каждой строке в коллекции

            char[] arrayChar = text.toCharArray();  // Разбиваем строку на символы и записываем их в массив

            char[] newArrayChar = new char[arrayChar.length]; // Создаем массив в который будем записывать полученные символы с помощью шифрования

            for (int i = 0; i < arrayChar.length; i++) { // Используем цикл for для перемещения по каждому символу строки
                int j = 0;
                do{ // используем цикл do-while для уменьшения итераций
                    if(arrayChar[i] == alphabet[j]) {
                        int index = j + encryptKey; 
                        if(index > alphabet.length - 1 ) {
                            index = (index - alphabet.length) % alphabet.length;
                        }
                        newArrayChar[i] = alphabet[index]; // Добавляем зашифрованный символ в массив
                        break; // Прерываем цикл, так как нет необходимости проходить его дальше
                    }
                    j++;

                   if(j > alphabet.length - 1){
                       throw new NotFoundSymbolException(Character.toString(arrayChar[i])); // В случае нахождения символа, которого нет в алфавите - выбрасываем исключение
                    }

                }while(true);
            }

            str.append(newArrayChar).append('\n'); // Записываем полученный массив в строку
        }

        Files.write(outputPath, str.toString().getBytes()); // Создаем файл и записываем строку в него

    }
    public void decrypt(String inputFile, String outputFile, int keyEncrypt, int keyStartIndexEncrypt) throws IOException {

        StringBuilder str = new StringBuilder();

        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);

        List<String> listInputFile = Files.readAllLines(inputPath); // Читаем все строки в файле inputPath и добавляем их построчно в коллекцию

        int keyFirstIndex = keyStartIndexEncrypt >= 0? keyStartIndexEncrypt % alphabet.length : keyStartIndexEncrypt % alphabet.length  + alphabet.length; // Значение индекса с которого будет происходить отсчет

        int encryptKey = keyEncrypt >= 0? keyEncrypt % alphabet.length + keyFirstIndex  : (keyEncrypt % alphabet.length) + keyFirstIndex  + alphabet.length; // Определяем по ключу, в каком направлении двигаться по массиву

        for(String text: listInputFile) { // Используем цикл for-each для прохода по каждой строке в коллекции

            char[] arrayChar = text.toCharArray();  // Разбиваем строку на символы и записываем их в массив

            char[] newArrayChar = new char[arrayChar.length]; // Создаем массив в который будем записывать полученные символы с помощью шифрования

            for (int i = 0; i < arrayChar.length; i++) { // Используем цикл for для перемещения по каждому символу строки
                int j = 0;
                do{ // используем цикл do-while для уменьшения итераций
                    if(arrayChar[i] == alphabet[j]) {
                        int index = j - encryptKey;
                        if(index < 0 ) {
                            index = (index + alphabet.length) % alphabet.length;
                        }
                        newArrayChar[i] = alphabet[index]; // Добавляем зашифрованный символ в массив
                        break; // Прерываем цикл, так как нет необходимости проходить его дальше
                    }
                    j++;

                    if(j > alphabet.length - 1){
                        throw new NotFoundSymbolException(Character.toString(arrayChar[i])); // В случае нахождения символа, которого нет в алфавите - выбрасываем исключение
                    }

                }while(true);
            }

            str.append(newArrayChar).append('\n'); // Записываем полученный массив в строку
        }

        Files.write(outputPath, str.toString().getBytes()); // Создаем файл и записываем строку в него
    }

}
