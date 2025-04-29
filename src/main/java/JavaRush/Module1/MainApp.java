package JavaRush.Module1;

import JavaRush.Module1.model.Cipher;
import JavaRush.Module1.validation.Validator;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Path;

public class MainApp
{
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ','й','ё'};


    private static Path inputFileForEncrypt;  // (Для тестов) "C:\\Users\\User\\Desktop\\TestModule1\\Text.txt";
    private static Path outputFileForEncrypt; // (Для тестов) "C:\\Users\\User\\Desktop\\TestModule1\\EncryptText.txt";


    private static Path inputFileForDecrypt;  // (Для тестов) "C:\\Users\\User\\Desktop\\TestModule1\\EncryptText.txt";
    private static Path outputFileForDecrypt; // (Для тестов) "C:\\Users\\User\\Desktop\\TestModule1\\DecryptText.txt";

    private static Path inputFileForBruteForce; //(Для тестов) "C:\\Users\\User\\Desktop\\TestModule1\\EncryptText.txt";
    private static Path outputDirectoryForBruteForce; //(Для тестов) "C:\\Users\\User\\Desktop\\TestModule1"

    private static int keyStartIndexEncrypt;

    private static int keyEncrypt;


    public static void main( String[] args )
    {
        System.out.println("-----------Шифр Цезаря-----------");
        System.out.println("-----------Шифрование текста-----------");
        keyEncrypt = Validator.keyEncrypt();
        keyStartIndexEncrypt = Validator.keyStartIndexEncrypt();
        inputFileForEncrypt = Validator.pathInputFile();
        outputFileForEncrypt = Validator.pathOutputFile();
        Cipher cipher = new Cipher(ALPHABET, keyEncrypt, keyStartIndexEncrypt);


        try {

            cipher.encrypt(inputFileForEncrypt,outputFileForEncrypt);

            System.out.println("-----------Расшифровка текста-----------");

            inputFileForDecrypt = Validator.pathInputFile();
            outputFileForDecrypt = Validator.pathOutputFile();

            cipher.decrypt(inputFileForDecrypt,outputFileForDecrypt);

            System.out.println("-----------Расшифровка текста методом BruteForce-----------");

            inputFileForBruteForce = Validator.pathInputFile();
            outputDirectoryForBruteForce = Validator.pathOutputDirectory();

            cipher.bruteForce(inputFileForBruteForce,outputDirectoryForBruteForce);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
