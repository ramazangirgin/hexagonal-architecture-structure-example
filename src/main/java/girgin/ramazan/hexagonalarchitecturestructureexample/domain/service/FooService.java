package girgin.ramazan.hexagonalarchitecturestructureexample.domain.service;

import girgin.ramazan.hexagonalarchitecturestructureexample.domain.exception.SomethingNotFoundException;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.external.servicea.ExternalServiceA;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.vo.FooDetailsVo;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.vo.RetrieveFooVo;
import org.springframework.stereotype.Service;

@Service
public class FooService {
    private final ExternalServiceA externalServiceA;

    public FooService(ExternalServiceA externalServiceA) {
        this.externalServiceA = externalServiceA;
    }

    public FooDetailsVo retrieveFoo(RetrieveFooVo retrieveFooVo) {
        Long retrievedValueOrDetails = externalServiceA.retrieveValue(retrieveFooVo.getPropertyOne(), retrieveFooVo.getPropertyThree());
        if (retrievedValueOrDetails < 0) { //just for show how service - exception interacts
            throw new SomethingNotFoundException();
        }
        return new FooDetailsVo.Builder()
                .id(retrievedValueOrDetails)//additional details could be added here
                .build();
    }
}
