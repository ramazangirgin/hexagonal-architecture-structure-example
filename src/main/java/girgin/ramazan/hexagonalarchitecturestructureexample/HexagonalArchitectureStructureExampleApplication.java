package girgin.ramazan.hexagonalarchitecturestructureexample;

import girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.interceptor.CorrelationIdInterceptor;
import girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.interceptor.LogExecutionInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class HexagonalArchitectureStructureExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexagonalArchitectureStructureExampleApplication.class, args);
    }

    @Bean
    public WebMvcConfigurerAdapter adapter() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new CorrelationIdInterceptor());
                registry.addInterceptor(new LogExecutionInterceptor());
            }
        };
    }

}

