package girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.external.messaging.events;

import java.io.Serializable;

public class FooCreatedEvent implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
