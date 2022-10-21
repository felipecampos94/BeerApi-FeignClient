package com.api.beerconsumer.controller;

import com.api.beerconsumer.model.BeerResponse;
import com.api.beerconsumer.service.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/beer")
public class BeerController {

    @Autowired
    private BeerService beerService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<BeerResponse> findById(@PathVariable Long id) {
        return beerService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BeerResponse> findByRandom() {
        return beerService.findByRandom();
    }

}
