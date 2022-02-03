package br.com.dio.api.resources;

import br.com.dio.api.connectors.HGBrasilConnectors;
import br.com.dio.api.models.PrevisaoTempoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrevisaoTempoResources {
    @Autowired
    HGBrasilConnectors connectors;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/")
    public ResponseEntity<PrevisaoTempoResponse> test() {
        var retornoApi = connectors.fecthWeatherForCity("Sao Paulo, sp");
        PrevisaoTempoResponse ret = null;

        if (retornoApi != null) {

            ret = PrevisaoTempoResponse.builder()
                    .nomeCidade(retornoApi.getCityName())
                    .hora(16)
                    .temperatura(retornoApi.getTemp())
                    .data(retornoApi.getDate())
                    .build();
        }
        return ResponseEntity.ok(ret);
    }

}
