package girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.model.request;

public class FooRequest {
    int id;
    String name;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public static final class FooRequestBuilder {
        int id;
        String name;

        private FooRequestBuilder() {
        }

        public static FooRequestBuilder aFooRequest() {
            return new FooRequestBuilder();
        }

        public FooRequestBuilder id(int id) {
            this.id = id;
            return this;
        }

        public FooRequestBuilder name(String name) {
            this.name = name;
            return this;
        }

        public FooRequest build() {
            FooRequest fooRequest = new FooRequest();
            fooRequest.id = this.id;
            fooRequest.name = this.name;
            return fooRequest;
        }
    }
}
