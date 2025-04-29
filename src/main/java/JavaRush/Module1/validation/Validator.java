package JavaRush.Module1.validation;

import JavaRush.Module1.exceptions.InvalidKeyValueException;

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
        System.out.println("Введите значение с которого будет происходить отсчет алфавита(от −2 147 483 648 до 2 147 483 647): ");
        if(scanner.hasNextInt()){
            return scanner.nextInt();
        }else{
            throw new InvalidKeyValueException();
        }
    }

}
