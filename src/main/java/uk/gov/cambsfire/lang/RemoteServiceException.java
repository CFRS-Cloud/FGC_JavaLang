package uk.gov.cambsfire.lang;

public class RemoteServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RemoteServiceException() {
        super();
    }

    public RemoteServiceException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RemoteServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RemoteServiceException(final String message) {
        super(message);
    }

    public RemoteServiceException(final Throwable cause) {
        super(cause);
    }

}
