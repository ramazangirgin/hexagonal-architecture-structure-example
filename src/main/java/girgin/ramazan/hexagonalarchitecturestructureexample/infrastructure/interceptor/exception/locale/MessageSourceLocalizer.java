package girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.interceptor.exception.locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageSourceLocalizer {

    private static final Logger logger = LoggerFactory.getLogger(MessageSourceLocalizer.class);

    private final MessageSource messageSource;

    public MessageSourceLocalizer(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getLocaleMessage(String key) {
        return getLocaleMessage(key, new Object[0]);
    }

    public String getLocaleMessage(String key, Object... args) {
        try {
            Locale locale = LocaleContextHolder.getLocale();
            return messageSource.getMessage(key, args, locale);
        } catch (NoSuchMessageException e) {
            logger.error(key + " not found in messages file", e);
            return String.format("???%s???", key);
        }
    }
}
