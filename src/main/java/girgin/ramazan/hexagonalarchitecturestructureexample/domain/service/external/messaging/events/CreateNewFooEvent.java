package girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.external.messaging.events;

import java.io.Serializable;

public class CreateNewFooEvent implements Serializable {
    private String name;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
