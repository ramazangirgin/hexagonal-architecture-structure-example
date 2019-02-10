package girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.controller;

import girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.converter.FooRequestToFooVoConverter;
import girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.mapper.FooResponseMapper;
import girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.model.dto.FooDto;
import girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.model.request.FooRequest;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.FooService;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.vo.FooDetailsVo;
import girgin.ramazan.hexagonalarchitecturestructureexample.domain.service.vo.RetrieveFooVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

    private final FooService fooService;
    private final FooRequestToFooVoConverter fooRequestToFooVoConverter;
    private final FooResponseMapper fooResponseMapper;

    public FooController(FooService fooService,
                         FooRequestToFooVoConverter fooRequestToFooVoConverter,
                         FooResponseMapper fooResponseMapper) {
        this.fooService = fooService;
        this.fooRequestToFooVoConverter = fooRequestToFooVoConverter;
        this.fooResponseMapper = fooResponseMapper;
    }


    @PostMapping("/api/v1/foos")
    @ResponseStatus(HttpStatus.OK)
    public FooDto retrieve(FooRequest fooRequest) {
        RetrieveFooVo retrieveFooVo = fooRequestToFooVoConverter.convert(fooRequest);
        FooDetailsVo fooDetailsVo = fooService.retrieveFoo(retrieveFooVo);
        return fooResponseMapper.map(fooDetailsVo);
    }
}