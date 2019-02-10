package girgin.ramazan.hexagonalarchitecturestructureexample.domain.repository;

import girgin.ramazan.hexagonalarchitecturestructureexample.domain.model.entity.Foo;

import java.util.List;

public interface FooRepository {

    Foo save(Foo foo);

    List<Foo> findAll();
}