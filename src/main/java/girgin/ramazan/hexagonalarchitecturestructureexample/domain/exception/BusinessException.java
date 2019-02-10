package girgin.ramazan.hexagonalarchitecturestructureexample.domain.exception;

public class BusinessException extends RuntimeException {
    private String messageKey;

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public BusinessException(String messageKey) {
        super();
        this.messageKey = messageKey;
    }

    public BusinessException(String messageKey, Throwable cause) {
        super(cause);
        this.messageKey = messageKey;
    }
}
