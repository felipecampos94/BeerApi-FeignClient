package com.api.beerconsumer;

import com.api.beerconsumer.model.BeerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerModelRespository extends JpaRepository<BeerModel, Long> {

    BeerModel findByIdBeerApi(Long id);
}
