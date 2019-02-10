package girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.interceptor.exception.locale;

import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Optional;

@Component
public class LocaleService {

    private Optional<Locale> getLocale() {
        LocaleContext localeContext = LocaleContextHolder.getLocaleContext();
        return Optional.ofNullable(localeContext)
                .map(localeContext1 -> localeContext1.getLocale());
    }

    public Optional<String> getLocaleLanguage() {
        Optional locale = getLocale();
        return locale.isPresent() ? Optional.of(((Locale) locale.get()).getLanguage()) : Optional.empty();
    }

    private Locale getLocaleOrDefault() {
        return getLocale().orElse(new Locale("TR"));
    }

    public String getLocaleLanguageOrDefault() {
        return getLocaleOrDefault().getLanguage();
    }
}