package br.com.dio.api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrevisaoTempoResponse {

    private Integer hora;
    private Integer temperatura;
    private String data;
    private String nomeCidade;
}
