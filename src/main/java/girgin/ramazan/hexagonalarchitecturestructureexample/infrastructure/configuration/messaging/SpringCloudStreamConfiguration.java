package girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.configuration.messaging;

import girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.configuration.messaging.channels.EventChannels;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@EnableBinding(EventChannels.class)
@Configuration
public class SpringCloudStreamConfiguration {
}
