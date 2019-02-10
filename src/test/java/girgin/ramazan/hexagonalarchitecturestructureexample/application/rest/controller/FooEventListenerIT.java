package girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.controller;

import girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.controller.base.BaseIT;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.model.enumtype.Status;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.repository.FooRepository;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.external.messaging.EventSender;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.external.messaging.events.CreateNewFooEvent;
import girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.configuration.messaging.channels.EventChannels;
import org.awaitility.Duration;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.integration.support.MessageBuilder;

import static org.awaitility.Awaitility.await;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class FooEventListenerIT extends BaseIT {
    @Autowired
    private EventChannels eventChannels;

    @Autowired
    FooRepository fooRepository;

    @SpyBean
    EventSender eventSender;

    @Test
    public void shouldHandleCreateNewFooEvent() {

        //given
        CreateNewFooEvent createNewFooEvent = new CreateNewFooEvent();
        createNewFooEvent.setName("Test Foo Name");
        createNewFooEvent.setLocation("Test Foo Location");

        //when
        eventChannels.fooCreateRequestedChannel()
                .send(MessageBuilder.withPayload(createNewFooEvent)
                        .build());

        //then
        await()
                .atMost(Duration.TEN_SECONDS)
                .with()
                .pollInterval(Duration.ONE_HUNDRED_MILLISECONDS)
                .until(() -> !fooRepository.findAll().isEmpty() &&
                        fooRepository.findAll().get(0).getName().equals("Test Foo Name") &&
                        fooRepository.findAll().get(0).getStatus().equals(Status.ACTIVE));

        await()
                .atMost(Duration.TEN_SECONDS)
                .with()
                .pollInterval(Duration.ONE_HUNDRED_MILLISECONDS)
                .until(() -> {
                    try {
                        verify(eventSender).sendFooCreatedEvent(any());
                        return true;
                    } catch (Exception exc) {
                        return false;
                    }
                });
    }
}
