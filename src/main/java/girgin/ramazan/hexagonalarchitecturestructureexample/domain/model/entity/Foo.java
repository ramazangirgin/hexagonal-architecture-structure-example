package girgin.ramazan.hexagonalarchitecturestructureexample.domain.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "foo")
public class Foo extends BaseEntity {

    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
