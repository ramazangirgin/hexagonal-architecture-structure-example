package girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.model.response;

public class ErrorResponse {

    private String code;
    private String locale;
    private String message;

    public String getCode() {
        return code;
    }

    public String getLocale() {
        return locale;
    }

    public String getMessage() {
        return message;
    }

    public static final class Builder {
        private String code;
        private String locale;
        private String message;

        public Builder() {
        }

        public static Builder anErrorResponse() {
            return new Builder();
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder locale(String locale) {
            this.locale = locale;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponse build() {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.message = this.message;
            errorResponse.locale = this.locale;
            errorResponse.code = this.code;
            return errorResponse;
        }
    }
}