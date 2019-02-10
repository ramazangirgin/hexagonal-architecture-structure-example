package girgin.ramazan.hexagonalarchitecturestructureexample.domain.service;

import girgin.ramazan.hexagonalarchitecturestructureexample.domain.exception.SomethingNotFoundException;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.model.entity.Foo;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.repository.FooRepository;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.external.servicea.ExternalServiceA;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.vo.CreateFooVo;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.vo.FooDetailsVo;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.vo.RetrieveFooVo;
import org.springframework.stereotype.Service;

@Service
public class FooService {
    private final FooRepository fooRepository;
    private final ExternalServiceA externalServiceA;

    public FooService(FooRepository fooRepository,
                      ExternalServiceA externalServiceA) {
        this.fooRepository = fooRepository;
        this.externalServiceA = externalServiceA;
    }

    public Long createFoo(CreateFooVo createFooVo) {
        Foo foo = new Foo();
        foo.setName(createFooVo.getName());
        fooRepository.save(foo);
        return foo.getId();
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
