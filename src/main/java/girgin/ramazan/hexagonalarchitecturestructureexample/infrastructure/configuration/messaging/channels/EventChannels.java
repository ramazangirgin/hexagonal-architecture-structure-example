package girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.configuration.messaging.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.SubscribableChannel;

public interface EventChannels extends Processor {

    String FOO_CREATED_CHANNEL = "fooCreatedChannel";
    String FOO_CREATE_REQUESTED_CHANNEL = "fooCreateRequestedChannel";

    @Input(FOO_CREATED_CHANNEL)
    SubscribableChannel fooCreatedChannel();

    @Input(FOO_CREATE_REQUESTED_CHANNEL)
    SubscribableChannel fooCreateRequestedChannel();
}
