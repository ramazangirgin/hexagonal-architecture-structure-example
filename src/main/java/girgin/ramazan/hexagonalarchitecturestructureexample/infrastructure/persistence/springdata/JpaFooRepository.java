package girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.persistence.springdata;

import girgin.ramazan.hexagonalarchitecturestructureexample.domain.model.entity.Foo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFooRepository extends JpaRepository<Foo, Long> {
}