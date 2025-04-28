package JavaRush.Module1.exceptions;

public class NotFoundPathForBruteForceException extends RuntimeException {
    public NotFoundPathForBruteForceException() {
      super("Ошибка! Данного пути не существует!");
    }
}

