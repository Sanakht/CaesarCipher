package JavaRush.Module1;

import JavaRush.Module1.model.Cipher;
import JavaRush.Module1.validation.Validator;

import java.io.IOException;
import java.nio.file.Path;

public class MainApp
{
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ','й','ё'};

    private static String inputFileForEncrypt = "C:\\Users\\User\\Desktop\\TestModule1\\Text.txt";
//    private static Path inputFileForEncrypt;
    private static String outputFileForEncrypt = "C:\\Users\\User\\Desktop\\TestModule1\\EncryptText.txt";

    private static String outputFileForDecrypt = "C:\\Users\\User\\Desktop\\TestModule1\\DecryptText.txt";

    private static String outputDirectoryForBruteForce = "C:\\Users\\User\\Desktop\\TestModule1";

    private static int keyStartIndexEncrypt;

    private static int keyEncrypt;


    public static void main( String[] args )
    {
        keyEncrypt = Validator.keyEncrypt();
        keyStartIndexEncrypt = Validator.keyStartIndexEncrypt();
//        inputFileForEncrypt = Validator.pathInputFileForEncrypt();
        Cipher cipher = new Cipher(ALPHABET, keyEncrypt, keyStartIndexEncrypt);


        try {
            cipher.encrypt(inputFileForEncrypt,outputFileForEncrypt);
            cipher.decrypt(outputFileForEncrypt,outputFileForDecrypt);
            cipher.bruteForce(outputFileForEncrypt,outputDirectoryForBruteForce);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
