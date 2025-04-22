package JavaRush.Module1;

import JavaRush.Module1.model.Cipher;

import java.io.IOException;
import java.nio.file.Path;

public class MainApp
{
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};


    public static void main( String[] args )
    {
        Cipher cipher = new Cipher(ALPHABET);

        String inputFileForEncrypt = "C:\\Users\\User\\Desktop\\TestModule1\\Text.txt";

        String outPutFileForEncrypt = "C:\\Users\\User\\Desktop\\TestModule1\\Text2.txt";

//        Path inputFile = Path.of("C:\\Users\\User\\Desktop\\TestModule1\\Text.txt");
//        Path outPutFile = Path.of("C:\\Users\\User\\Desktop\\TestModule1\\Text2.txt");


        try {
            cipher.encrypt(inputFileForEncrypt,outPutFileForEncrypt,5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
