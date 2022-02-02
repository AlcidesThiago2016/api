package br.com.dio.api.connectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.dio.api.models.HGBrasilResponse;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class HGBrasilConnectors {

    private final String SCHEME = "https";
    private static final String HOST = "api.hgbrasil.com";
    private static final String URI = "weather";
    private static final String API_KEY = "8a8a6da1";
    private static final String API_FIELDS = "only_results,temp,city_name,forecast,max,min,date";

    @Autowired
    private RestTemplate restTemplate;

    public HGBrasilResponse fecthWeatherForCity (String city)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
        uriBuilder.scheme(SCHEME).host(HOST).path(URI);
        return null;
    }
}
