package JavaRush.Module1;

import JavaRush.Module1.model.Cipher;

import java.io.IOException;
import java.nio.file.Path;

public class MainApp
{
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ','й','ё'};

    public static String inputFileForEncrypt = "C:\\Users\\User\\Desktop\\TestModule1\\Text.txt";

    public static String outPutFileForEncrypt = "C:\\Users\\User\\Desktop\\TestModule1\\EncryptText.txt";


    public static void main( String[] args )
    {
        Cipher cipher = new Cipher(ALPHABET);


        try {
            cipher.encrypt(inputFileForEncrypt,outPutFileForEncrypt,5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
