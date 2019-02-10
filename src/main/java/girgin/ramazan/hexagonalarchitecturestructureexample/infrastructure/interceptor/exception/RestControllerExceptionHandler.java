package girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.interceptor.exception;

import girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.exception.UnwantedCharacterInNameException;
import girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.model.response.ErrorResponse;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.exception.BusinessException;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.exception.SomethingNotFoundException;
import girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.interceptor.exception.locale.MessageSourceLocalizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestControllerExceptionHandler.class);

    private final MessageSourceLocalizer messageSourceLocalizer;

    public RestControllerExceptionHandler(MessageSourceLocalizer messageSourceLocalizer) {
        this.messageSourceLocalizer = messageSourceLocalizer;
    }

    @ExceptionHandler(SomethingNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleProductNotFoundException(Locale locale, SomethingNotFoundException ex) {
        logger.error(ex.getMessageKey(), ex);
        return convertExceptionToResponse(locale, ex);
    }

    @ExceptionHandler(UnwantedCharacterInNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUnwantedCharacterInNameException(Locale locale, UnwantedCharacterInNameException ex) {
        logger.error(ex.getMessageKey(), ex);
        return convertExceptionToResponse(locale, ex);
    }

    private ErrorResponse convertExceptionToResponse(Locale locale, BusinessException ex) {
        String localizedMessage = messageSourceLocalizer.getLocaleMessage(ex.getLocalizedMessage());
        Pair<String, String> codeAndMessage = parseMessage(localizedMessage);
        return new ErrorResponse.Builder()
                .code(codeAndMessage.getFirst())
                .message(codeAndMessage.getSecond())
                .locale(locale.getDisplayName())
                .build();
    }

    private Pair<String, String> parseMessage(String message) {
        String[] codeAndMessage = message.split(";");
        if (codeAndMessage.length != 2) {
            logger.error("Format error in locatization for message: " + message);
            return Pair.of("", message);
        }
        return Pair.of(codeAndMessage[0], codeAndMessage[1]);
    }
}