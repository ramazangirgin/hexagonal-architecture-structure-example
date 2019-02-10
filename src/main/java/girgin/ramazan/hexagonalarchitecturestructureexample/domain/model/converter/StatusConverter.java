package girgin.ramazan.hexagonalarchitecturestructureexample.domain.model.converter;


import girgin.ramazan.hexagonalarchitecturestructureexample.domain.model.enumtype.Status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter
public class StatusConverter implements AttributeConverter<Status, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Status status) {
        return status.getValue();
    }

    @Override
    public Status convertToEntityAttribute(Integer value) {
        return Stream.of(Status.values())
                .filter(status -> status.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }
}
