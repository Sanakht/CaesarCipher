package JavaRush.Module1;

import JavaRush.Module1.model.Cipher;

public class MainApp
{
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};


    public static void main( String[] args )
    {
       Cipher cipher = new Cipher(ALPHABET);

       String text = "добавить массив";

        System.out.println(cipher.encrypt(text, 5));

//        StringBuilder stringBuilder = new StringBuilder();
//        char[] chars = text.toCharArray();
//        stringBuilder.append(text);
//        System.out.println(stringBuilder);
    }
}
