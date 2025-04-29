package JavaRush.Module1.exceptions;

public class UnknownError extends RuntimeException {
    public UnknownError() {
        super("Неизвестная ошибка!");
    }
}
