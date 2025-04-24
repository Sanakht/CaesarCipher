package JavaRush.Module1;

import JavaRush.Module1.model.Cipher;

import java.io.IOException;
import java.nio.file.Path;

public class MainApp
{
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ','й','ё'};

    private static String inputFileForEncrypt = "C:\\Users\\User\\Desktop\\TestModule1\\Text.txt";

    private static String outputFileForEncrypt = "C:\\Users\\User\\Desktop\\TestModule1\\EncryptText.txt";

    private static String outputFileForDecrypt = "C:\\Users\\User\\Desktop\\TestModule1\\DecryptText.txt";

    private static int keyStartIndexEncrypt = 7;

    private static int keyEncrypt = 5;


    public static void main( String[] args )
    {
        Cipher cipher = new Cipher(ALPHABET);


        try {
            cipher.encrypt(inputFileForEncrypt,outputFileForEncrypt, keyEncrypt, keyStartIndexEncrypt);
            cipher.decrypt(outputFileForEncrypt,outputFileForDecrypt, keyEncrypt, keyStartIndexEncrypt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
