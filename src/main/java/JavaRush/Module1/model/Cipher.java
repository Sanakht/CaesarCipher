package JavaRush.Module1.model;

import JavaRush.Module1.exceptions.NotFoundPathForBruteForceException;
import JavaRush.Module1.exceptions.NotFoundSymbolException;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.List;

public class Cipher {

    private static char[] alphabet;

    private static int pathKey;

    public Cipher(char[] alphabet, int keyEncrypt, int keyStartIndexEncrypt) {
        this.alphabet = alphabet;
        int keyFirstIndex = keyStartIndexEncrypt >= 0 ? keyStartIndexEncrypt % alphabet.length : keyStartIndexEncrypt % alphabet.length + alphabet.length; // Расчет значения индекса с которого будет происходить отсчет
        pathKey = keyEncrypt >= 0? keyEncrypt % alphabet.length + keyFirstIndex : (keyEncrypt % alphabet.length) + keyFirstIndex + alphabet.length; // Определяем по ключу, в каком направлении двигаться по массиву
    }

    public void encrypt(String inputFile, String outputFile) throws IOException {
        System.out.println("Начинаю шифрование...");
       StringBuilder str = new StringBuilder();

       Path inputPath = Paths.get(inputFile);
       Path outputPath = Paths.get(outputFile);

       List<String> listInputFile = Files.readAllLines(inputPath); // Читаем все строки в файле inputPath и добавляем их построчно в коллекцию

        for(String text: listInputFile) { // Используем цикл for-each для прохода по каждой строке в коллекции

            char[] arrayChar = text.toCharArray();  // Разбиваем строку на символы и записываем их в массив

            char[] newArrayChar = new char[arrayChar.length]; // Создаем массив в который будем записывать полученные символы с помощью шифрования

            for (int i = 0; i < arrayChar.length; i++) { // Используем цикл for для перемещения по каждому символу строки
                int j = 0;
                do{ // используем цикл do-while для уменьшения итераций
                    if(arrayChar[i] == alphabet[j]) {
                        int index = j + pathKey;
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
        System.out.println("Шифрование закончил!");
    }

    public void decrypt(String inputFile, String outputFile) throws IOException {
        System.out.println("Начинаю расшифровку...");
        StringBuilder str = new StringBuilder();

        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);

        List<String> listInputFile = Files.readAllLines(inputPath); // Читаем все строки в файле inputPath и добавляем их построчно в коллекцию

        for(String text: listInputFile) { // Используем цикл for-each для прохода по каждой строке в коллекции

            char[] arrayChar = text.toCharArray();  // Разбиваем строку на символы и записываем их в массив

            char[] newArrayChar = new char[arrayChar.length]; // Создаем массив в который будем записывать полученные символы с помощью шифрования

            for (int i = 0; i < arrayChar.length; i++) { // Используем цикл for для перемещения по каждому символу строки
                int j = 0;
                do{ // используем цикл do-while для уменьшения итераций
                    if(arrayChar[i] == alphabet[j]) {
                        int index = j - pathKey;
                        if(index < 0 ) {
                            index = (index + alphabet.length) % alphabet.length;
                        }
                        newArrayChar[i] = alphabet[index]; // Добавляем расшифрованный символ в массив
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
        System.out.println("Расшифровку закончил!");
    }

    public void bruteForce(String inputFile, String outputDirectory) throws IOException {

       Path inputPath = Paths.get(inputFile);
       Path outputPathDirectory = Paths.get(outputDirectory);
       Path newBruteForcePath;

       if(Files.isDirectory(outputPathDirectory)) { // Проверка данного пути, что это директория
           if(outputPathDirectory.endsWith("BruteForce")){ // Проверяем что мы находимся в папке, где будем хранить результаты расшифровки с помощью метода BruteForce
               System.out.println("Путь указан в папку BruteForce. Запись расшифрованных файлов будет произведена в данную папку!");
                newBruteForcePath = outputPathDirectory;
           }else if(Files.exists(Paths.get(outputPathDirectory + "\\BruteForce"))) { // Если по данному пути, есть папка BruteForce
               System.out.println("По данному пути есть папка BruteForce.");
                newBruteForcePath = Paths.get(outputPathDirectory + "\\BruteForce");
           }else{ //Если по данному пути, нет папка BruteForce - создаем
               System.out.println("Путь указан в место хранения. Создаем папку для хранения файлов, после расшифровки с помощью метода BruteForce!");
                newBruteForcePath = Paths.get(outputPathDirectory + "\\BruteForce");
               Files.createDirectories(newBruteForcePath);
           }
       }else{
           throw new NotFoundPathForBruteForceException();
       }

        List<String> listInputFile = Files.readAllLines(inputPath); // Читаем все строки в файле inputPath и добавляем их построчно в коллекцию

        for (int f = 0; f < alphabet.length; f++) { // Используем цикл for для прохода по каждому символу алфавита

            StringBuilder str = new StringBuilder();

            for(String text: listInputFile) { // Используем цикл for-each для прохода по каждой строке в коллекции

                char[] arrayChar = text.toCharArray();  // Разбиваем строку на символы и записываем их в массив

                char[] newArrayChar = new char[arrayChar.length]; // Создаем массив в который будем записывать полученные символы с помощью шифрования

                for (int i = 0; i < arrayChar.length; i++) { // Используем цикл for для перемещения по каждому символу строки
                    int j = 0;
                    do{ // используем цикл do-while для уменьшения итераций
                        if(arrayChar[i] == alphabet[j]) {
                            int index = j - f; // Изменяем индекс на константу
                            if(index < 0 ) {
                                index = (index + alphabet.length) % alphabet.length;
                            }
                            newArrayChar[i] = alphabet[index]; // Добавляем расшифрованный символ в массив
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
            String path = String.format("\\%s%d.txt","DecryptText",f); // Добавляем название файла с номером
            Files.write(Paths.get(newBruteForcePath + path), str.toString().getBytes()); // Создаем файл в папке BruteForce и записываем строку в него

        }
        System.out.println("Расшифровку закончил с помощью метода BruteForce!");


    }



}
