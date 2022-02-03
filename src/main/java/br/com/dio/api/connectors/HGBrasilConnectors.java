package br.com.dio.api.connectors;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.dio.api.models.HGBrasilResponse;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Component
@Slf4j
public class HGBrasilConnectors {

    private static final String SCHEME = "https";
    private static final String HOST = "api.hgbrasil.com";
    private static final String URI = "weather";
    private static final String API_KEY = "8a8a6da1";
    private static final String API_FIELDS = "only_results,temp,city_name,forecast,max,min,date";
    private static final int MAX_ARRAY_RESULTS = 3;

    @Autowired
    private RestTemplate restTemplate;

    public HGBrasilResponse fecthWeatherForCity (String city)
    {
        log.info("Consultando a API da HG Brasil para a cidade {}", city);

        HttpEntity<?> entity = createHeaders();

        var uriComponentsBuilder = createUriBuilder(city);

        log.info("Url para chamada da api hgbrasil {} ", uriComponentsBuilder.toUriString());

        final ResponseEntity<HGBrasilResponse> responseEntity = this.restTemplate.exchange(uriComponentsBuilder.toUriString(),
                HttpMethod.GET, entity, HGBrasilResponse.class);

        HGBrasilResponse response = Optional.ofNullable(responseEntity.getBody()).orElse(null);

        return response;
    }

    private UriComponentsBuilder createUriBuilder(String city) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
        uriBuilder.scheme(SCHEME).host(HOST).path(URI);
        uriBuilder.queryParam("key",API_KEY);
        uriBuilder.queryParam("array_limit", MAX_ARRAY_RESULTS);
        uriBuilder.queryParam("fields", API_FIELDS);
        uriBuilder.queryParam("city", city);
        return uriBuilder;
    }

    private HttpEntity<?> createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return null;
    }
}
