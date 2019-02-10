package girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.converter;

import girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.model.request.FooRequest;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.vo.RetrieveFooVo;
import org.springframework.stereotype.Component;

@Component
public class FooRequestToFooVoConverter {
    public RetrieveFooVo convert(FooRequest fooRequest) {
        return new RetrieveFooVo.Builder()
                .propertyOne(fooRequest.getName())
                .build();
    }
}
