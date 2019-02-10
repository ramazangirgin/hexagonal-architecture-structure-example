package girgin.ramazan.hexagonalarchitecturestructureexample.domain.repository;

import girgin.ramazan.hexagonalarchitecturestructureexample.domain.model.entity.Foo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FooRepository extends JpaRepository<Foo, Long> {
}