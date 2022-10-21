package com.api.beerconsumer.model;

import lombok.Data;

@Data
public class BeerResponse {

    private Long id;
    private String name;
    private String tagline;
    private String description;
    private Long abv;
    private Long ibu;
}
