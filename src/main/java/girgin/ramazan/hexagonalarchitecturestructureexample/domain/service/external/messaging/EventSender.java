package girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.external.messaging;

import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.external.messaging.events.FooCreatedEvent;

public interface EventSender {//Basic event sender, could be event type based or general

    void sendFooCreatedEvent(FooCreatedEvent fooCreatedEvent);
}
