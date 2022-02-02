package br.com.dio.api.resources;

import br.com.dio.api.models.PrevisaoTempoResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrevisaoTempoResources {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/")
    public ResponseEntity<PrevisaoTempoResponse> test()
    {
        var ret = PrevisaoTempoResponse.builder().nomeCidade("Brasilia").hora(16).temperatura(23).build();
        return ResponseEntity.ok(ret);
    }

}
