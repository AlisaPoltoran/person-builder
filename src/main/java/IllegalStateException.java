import java.util.function.Supplier;

public class IllegalStateException extends Throwable {

    public IllegalStateException(String msg) {
        super(String.format(msg));
    }
}
