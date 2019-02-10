package girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.vo;

public class RetrieveFooVo {
    private String propertyOne;
    private String propertyTwo;
    private String propertyThree;

    public String getPropertyOne() {
        return propertyOne;
    }

    private void setPropertyOne(String propertyOne) {
        this.propertyOne = propertyOne;
    }

    public String getPropertyTwo() {
        return propertyTwo;
    }

    private void setPropertyTwo(String propertyTwo) {
        this.propertyTwo = propertyTwo;
    }

    public String getPropertyThree() {
        return propertyThree;
    }

    private void setPropertyThree(String propertyThree) {
        this.propertyThree = propertyThree;
    }

    public static final class Builder {
        private String propertyOne;
        private String propertyTwo;
        private String propertyThree;

        public Builder() {
        }

        public static Builder aRetrieveFooVo() {
            return new Builder();
        }

        public Builder propertyOne(String propertyOne) {
            this.propertyOne = propertyOne;
            return this;
        }

        public Builder propertyTwo(String propertyTwo) {
            this.propertyTwo = propertyTwo;
            return this;
        }

        public Builder propertyThree(String propertyThree) {
            this.propertyThree = propertyThree;
            return this;
        }

        public RetrieveFooVo build() {
            RetrieveFooVo retrieveFooVo = new RetrieveFooVo();
            retrieveFooVo.propertyOne = this.propertyOne;
            retrieveFooVo.propertyThree = this.propertyThree;
            retrieveFooVo.propertyTwo = this.propertyTwo;
            return retrieveFooVo;
        }
    }
}
