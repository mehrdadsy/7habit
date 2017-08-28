package  ir.mehrdadseyfi.a7habit.action.service;

/**
 * @author Sam
 * @version 1.0
 */
@SuppressWarnings("UnusedDeclaration")
public enum Error {
    UNKNOWN_ERROR(9000),
    INVALID_LICENSE(9001),
    LICENSE_EXPIRED(9002),
    LICENSE_EXCEEDED(9003),
    INVALID_ACTIVATION_KEY(9004),
    INVALID_CHECKSUM(9005),
    INVALID_RESPONSE(9006),

    NOT_ACTIVATED(8001);

    private int code;
    private Error(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }
}
