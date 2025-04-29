package JavaRush.Module1.exceptions;

public class NotFoundFileException extends RuntimeException {
    public NotFoundFileException(String message) {
        super("Файл " + message + " не существует!");
    }
}
