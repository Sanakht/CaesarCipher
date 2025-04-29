package JavaRush.Module1.exceptions;

public class NotFoundFileException extends RuntimeException {
    public NotFoundFileException() {
        super("Файл не существует!");
    }
}
