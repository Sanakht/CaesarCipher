package JavaRush.Module1.validation;

import JavaRush.Module1.exceptions.InvalidFilePathException;
import JavaRush.Module1.exceptions.InvalidKeyValueException;
import JavaRush.Module1.exceptions.NotFoundFileException;
import JavaRush.Module1.exceptions.UnknownError;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Validator {
    private Validator() {
    }

   private static Scanner scanner;

    public static int keyEncrypt(){
        scanner = new Scanner(System.in);
        System.out.println("Введите значение ключа(от −2 147 483 648 до 2 147 483 647): ");
        if(scanner.hasNextInt()){
            return scanner.nextInt();
        }else{
            throw new InvalidKeyValueException();
        }
    }

    public static int keyStartIndexEncrypt(){
        scanner = new Scanner(System.in);
        System.out.println("Введите значение сдвига алфавита с которого будет происходить отсчет(от −2 147 483 648 до 2 147 483 647): ");
        if(scanner.hasNextInt()){
            return scanner.nextInt();
        }else{
            throw new InvalidKeyValueException();
        }
    }

    public static Path pathInputFile(){
        scanner = new Scanner(System.in);
        System.out.println("Введите абсолютный путь файла входных данных: ");
        if(scanner.hasNextLine()){
            String path = scanner.nextLine();
            Path inputFile = Paths.get(path);
            if(inputFile.isAbsolute()) {
                if (Files.isRegularFile(inputFile)) {
                    return inputFile;
                } else {
                    throw new NotFoundFileException();
                }
            }else{
                throw new InvalidFilePathException();
            }
        }else{
            throw new UnknownError();
        }
    }

    public static Path pathOutputFile()  {
        scanner = new Scanner(System.in);
        System.out.println("Введите абсолютный путь файла выходных данных в формате .txt: ");
        if(scanner.hasNextLine()){
            String path = scanner.nextLine();
            Path outputFile = Paths.get(path);
            if(outputFile.isAbsolute() && outputFile.toString().endsWith(".txt")) {
                if (!Files.isRegularFile(outputFile)) {
                    try {
                        Files.createFile(outputFile);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                return outputFile;
            }else{
                throw new InvalidFilePathException();
            }
        }else {
            throw new UnknownError();
        }
    }

    public static Path pathOutputDirectory(){
        System.out.println("Введите абсолютный путь директории, где будут храниться файлы: ");
        scanner = new Scanner(System.in);
        if(scanner.hasNextLine()){
            String path = scanner.nextLine();
            Path outputDirectory = Paths.get(path);
            if(Files.isDirectory(outputDirectory)) {
                return outputDirectory;
            }else{
                throw new RuntimeException("Неверно указан путь к директории!");
            }
        }else{
            throw new UnknownError();
        }
    }

}
