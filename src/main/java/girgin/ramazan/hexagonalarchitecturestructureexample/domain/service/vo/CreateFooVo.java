package girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.vo;

public class CreateFooVo {
    private String name;
    private String location;

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    private void setLocation(String location) {
        this.location = location;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String location;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public CreateFooVo build() {
            CreateFooVo fooDetailsVo = new CreateFooVo();
            fooDetailsVo.location = this.location;
            fooDetailsVo.name = this.name;
            return fooDetailsVo;
        }
    }
}
