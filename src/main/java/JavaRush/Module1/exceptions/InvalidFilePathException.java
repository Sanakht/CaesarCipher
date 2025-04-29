package JavaRush.Module1.exceptions;

public class InvalidFilePathException extends RuntimeException {
    public InvalidFilePathException(String message) {
        super("Неверно указать путь к файлу " + message + "!");
    }
}
