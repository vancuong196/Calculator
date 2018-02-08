package projecttest.com.calculator;

/**
 * Created by Cuong on 2/8/2018.
 */

public class MathExpressionErrorException extends Exception {
    String message;
    public MathExpressionErrorException(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
