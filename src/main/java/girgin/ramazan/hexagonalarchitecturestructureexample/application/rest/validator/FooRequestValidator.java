package girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.validator;

import girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.exception.UnwantedCharacterInNameException;
import girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.model.request.FooRequest;

public class FooRequestValidator {
    public void validate(FooRequest fooRequest){
        if (fooRequest.getName().contains("UnwantedName")){
            throw new UnwantedCharacterInNameException();
        }
    }
}
