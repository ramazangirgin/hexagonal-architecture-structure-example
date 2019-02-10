package girgin.ramazan.hexagonalarchitecturestructureexample.infrastructure.persistence.springdata;

import girgin.ramazan.hexagonalarchitecturestructureexample.domain.model.entity.Foo;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.repository.FooRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FooRepositoryImpl implements FooRepository {
    private final JpaFooRepository jpaFooRepository;

    public FooRepositoryImpl(JpaFooRepository jpaFooRepository) {
        this.jpaFooRepository = jpaFooRepository;
    }

    @Override
    public Foo save(Foo foo) {
        return jpaFooRepository.save(foo);
    }

    @Override
    public List<Foo> findAll() {
        return jpaFooRepository.findAll();
    }
}