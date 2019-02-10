package girgin.ramazan.hexagonalarchitecturestructureexample.application.eventqueue;

import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.FooService;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.external.messaging.EventSender;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.external.messaging.events.CreateNewFooEvent;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.external.messaging.events.FooCreatedEvent;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.vo.CreateFooVo;
import girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.configuration.messaging.channels.EventChannels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class FooEventListener {

    private static final Logger logger = LoggerFactory.getLogger(FooEventListener.class);

    private final FooService fooService;
    private final EventSender eventSender;

    public FooEventListener(FooService fooService, EventSender eventSender) {
        this.fooService = fooService;
        this.eventSender = eventSender;
    }

    @StreamListener(EventChannels.FOO_CREATE_REQUESTED_CHANNEL)
    public void handleCreateNewFooEvent(CreateNewFooEvent createNewFooEvent) {
        CreateFooVo createFooVo = new CreateFooVo.Builder()
                .name(createNewFooEvent.getName())
                .location(createNewFooEvent.getLocation())
                .build();
        Long id = fooService.createFoo(createFooVo);
        FooCreatedEvent fooCreatedEvent = new FooCreatedEvent();
        fooCreatedEvent.setId(id);
        eventSender.sendFooCreatedEvent(fooCreatedEvent);
    }

    @StreamListener(EventChannels.FOO_CREATED_CHANNEL)
    public void handleFooCreatedEvent(FooCreatedEvent fooCreatedEvent) {
        logger.info("Foo created with id: " + fooCreatedEvent.getId());
    }
}
