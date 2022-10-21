package com.api.beerconsumer.face;

import com.api.beerconsumer.model.BeerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "BeerClient", url = "https://api.punkapi.com/v2/beers")
public interface BeerClient {

    @GetMapping(value = "/random")
    List<BeerResponse> getRamdomBeer();

    @GetMapping(value = "/{id}")
    List<BeerResponse> getBeerById(@PathVariable("id") Long id);
}
