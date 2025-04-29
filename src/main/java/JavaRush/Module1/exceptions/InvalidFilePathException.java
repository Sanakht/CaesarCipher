package JavaRush.Module1.exceptions;

public class InvalidFilePathException extends RuntimeException {
    public InvalidFilePathException() {
        super("Неверно указать путь к файлу!");
    }
}
