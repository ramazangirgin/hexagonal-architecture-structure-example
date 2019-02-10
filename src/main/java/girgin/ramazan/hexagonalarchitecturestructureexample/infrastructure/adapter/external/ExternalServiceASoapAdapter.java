package girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.adapter.external;

import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.external.servicea.ExternalServiceA;
import org.springframework.stereotype.Service;

@Service
public class ExternalServiceASoapAdapter implements ExternalServiceA {

    @Override
    public Long retrieveValue(String propertyOne, String propertyThree) {
        //retrieve value from external service, with saop api. could be other adapter types
        return 1L;
    }
}
