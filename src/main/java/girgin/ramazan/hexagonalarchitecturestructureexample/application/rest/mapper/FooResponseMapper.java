package girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.mapper;

import girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.model.dto.FooDto;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.vo.FooDetailsVo;
import org.springframework.stereotype.Component;

@Component
public class FooResponseMapper {
    //could be implemented with mapstruct or converted to mapstruct
    public FooDto map(FooDetailsVo fooDetailsVo) {
        return new FooDto.Builder()
                .id(fooDetailsVo.getId())
                .name(fooDetailsVo.getName())
                .build();
    }
}
