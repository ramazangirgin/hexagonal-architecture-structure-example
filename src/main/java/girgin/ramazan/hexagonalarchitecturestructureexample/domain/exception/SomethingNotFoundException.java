package girgin.ramazan.hexagonalarchitecturestructureexample.domain.exception;

public class SomethingNotFoundException extends BusinessException {

    public SomethingNotFoundException() {
        super("error.while.doing.something");
    }
}
