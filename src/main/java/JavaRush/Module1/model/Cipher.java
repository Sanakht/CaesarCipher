package JavaRush.Module1.model;

public class Cipher {

    private char[] alphabet;

    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift) {

        char[] arrayChar = text.toCharArray();

        char[] newArrayChar = new char[arrayChar.length];

        for (int i = 0; i < arrayChar.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {

                if(arrayChar[i] == alphabet[j]) {
                   int index = j + shift;
                   if(index > alphabet.length - 1 ) {
                       index = index - alphabet.length;
                       newArrayChar[i] = alphabet[index];
                   }
                   newArrayChar[i] = alphabet[index];
                }
            }
        }

        StringBuilder str = new StringBuilder();
        str.append(newArrayChar);
        return str.toString();
    }
    public String decrypt(String encryptedText, int shift) {
        // Логика расшифровки
        return "";
    }

}
