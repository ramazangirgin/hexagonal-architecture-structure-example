package girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.interceptor;

import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.UUID;

public class CorrelationIdInterceptor extends HandlerInterceptorAdapter {

    private static final String CORRELATION_ID_HEADER_NAME = "x-correlation-id";
    private static final String CORRELATION_ID_LOG_VAR_NAME = "correlationId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MDC.put(CORRELATION_ID_LOG_VAR_NAME, getCorrelationId(request));
        return true;
    }

    private String getCorrelationId(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(CORRELATION_ID_HEADER_NAME))
                .orElseGet(() -> UUID.randomUUID().toString());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove(CORRELATION_ID_LOG_VAR_NAME);
    }
}