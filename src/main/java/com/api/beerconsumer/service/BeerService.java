package com.api.beerconsumer.service;

import com.api.beerconsumer.BeerModelRespository;
import com.api.beerconsumer.face.BeerClient;
import com.api.beerconsumer.model.BeerModel;
import com.api.beerconsumer.model.BeerResponse;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    @Autowired
    private BeerClient beerClient;

    @Autowired
    private BeerModelRespository respository;

    public List<BeerResponse> findById(Long id) {
        List<BeerResponse> responses = beerClient.getBeerById(id);
        if (responses.isEmpty()) {
            System.out.println("Object Not Found!");
        }
        insert(responses);
        return responses;
    }

    public List<BeerResponse> findByRandom() {
        return beerClient.getRamdomBeer();
    }

    public BeerModel findByIdBeerModel(Long id) {
        BeerModel object = respository.findByIdBeerApi(id);
        if (object != null) {
            throw new ObjectNotFoundException(BeerModel.class,
                    "Objeto já cadastrado! IdBeerApi " + object.getIdBeerApi());
        }
        return object;
    }

    public BeerModel insert(List<BeerResponse> response) {
        BeerModel object = new BeerModel();
        object.setId(null);

        for (BeerResponse item : response) {
            findByIdBeerModel(item.getId());
            object.setIdBeerApi(item.getId());
            object.setName(item.getName());
            object.setTagline(item.getTagline());
            object.setDescription(item.getDescription());
            object.setAbv(item.getAbv());
            object.setIbu(item.getIbu());
        }
        return respository.save(object);
    }
}
