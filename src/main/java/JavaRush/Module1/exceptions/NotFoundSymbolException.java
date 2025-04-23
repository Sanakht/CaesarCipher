package JavaRush.Module1.exceptions;

public class NotFoundSymbolException extends RuntimeException {
    public NotFoundSymbolException(String name) {
        super(name + " - символ в алфавите не найден.");
    }
}
