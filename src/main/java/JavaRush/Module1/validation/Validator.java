package JavaRush.Module1.validation;

import JavaRush.Module1.exceptions.InvalidFilePathException;
import JavaRush.Module1.exceptions.InvalidKeyValueException;
import JavaRush.Module1.exceptions.NotFoundFileException;
import JavaRush.Module1.exceptions.UnknownError;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Validator {
    private Validator() {
    }

   private static Scanner scanner = new Scanner(System.in);

    public static int keyEncrypt(){
        System.out.println("Введите значение ключа(от −2 147 483 648 до 2 147 483 647): ");
        if(scanner.hasNextInt()){
            return scanner.nextInt();
        }else{
            throw new InvalidKeyValueException();
        }
    }

    public static int keyStartIndexEncrypt(){
        System.out.println("Введите значение сдвига алфавита с которого будет происходить отсчет(от −2 147 483 648 до 2 147 483 647): ");
        if(scanner.hasNextInt()){
            return scanner.nextInt();
        }else{
            throw new InvalidKeyValueException();
        }
    }

    public static Path pathInputFileForEncrypt(){
        System.out.println("Введите путь хранения файла для шифрования в формате .txt: ");
        if(scanner.hasNextLine()){
            scanner.nextLine();
            String path = scanner.nextLine();
            Path inputFileForEncrypt = Paths.get(path);
            if(inputFileForEncrypt.isAbsolute()) {
                if (Files.isRegularFile(inputFileForEncrypt)) {
                    return inputFileForEncrypt;
                } else {
                    throw new NotFoundFileException("для шифрования");
                }
            }else{
                throw new InvalidFilePathException("шифрования");
            }
        }else{
            throw new UnknownError();
        }
    }

}
