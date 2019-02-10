package girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.adapter.messaging;

import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.external.messaging.EventSender;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.external.messaging.events.FooCreatedEvent;
import girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.configuration.messaging.channels.EventChannels;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class StringCloudStreamEventSender implements EventSender {

    private final EventChannels eventChannels;

    public StringCloudStreamEventSender(EventChannels eventChannels) {
        this.eventChannels = eventChannels;
    }

    @Override
    public void sendFooCreatedEvent(FooCreatedEvent fooCreatedEvent) {
        eventChannels.fooCreatedChannel()
                .send(MessageBuilder.withPayload(fooCreatedEvent)
                        .build());
    }
}
