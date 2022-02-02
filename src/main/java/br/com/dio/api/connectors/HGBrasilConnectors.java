package br.com.dio.api.connectors;

import br.com.dio.api.models.HGBrasilResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HGBrasilConnectors {

    @Autowired
    private RestTemplate restTemplate;

    public HGBrasilResponse fecthWeatherForCity (String city)
    {
        return null;
    }
}
