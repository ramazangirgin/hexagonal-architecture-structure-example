package girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.exception;

import girgin.ramazan.hexagonalarchitecturestructureexample.domain.exception.BusinessException;

public class UnwantedCharacterInNameException extends BusinessException {
    public UnwantedCharacterInNameException() {
        super("validation.error.unwanted.character.in.foo.request.name");
    }
}
