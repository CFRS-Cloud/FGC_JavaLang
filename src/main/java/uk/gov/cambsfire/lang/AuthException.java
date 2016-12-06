package uk.gov.cambsfire.lang;

public class AuthException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AuthException() {
        super();
    }

    public AuthException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AuthException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public AuthException(final String message) {
        super(message);
    }

    public AuthException(final Throwable cause) {
        super(cause);
    }

}
