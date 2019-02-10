package girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.model.dto;

public class FooDto {
    private Long id;
    private String name;

    private FooDto(Builder builder) {
        setId(builder.id);
        setName(builder.name);
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public static final class Builder {
        private Long id;
        private String name;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public FooDto build() {
            return new FooDto(this);
        }
    }
}
