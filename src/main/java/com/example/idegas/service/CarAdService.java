package com.example.idegas.service;

import com.example.idegas.dto.CarAd;
import com.example.idegas.dao.CarAdRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarAdService {

    private static final Logger logger = LoggerFactory.getLogger(CarAdService.class);

    private final CarAdRepository carAdRepository;

    @Autowired
    public CarAdService(CarAdRepository carAdRepository) {
        this.carAdRepository = carAdRepository;
    }

    // Dodajanje novega avtomobilskega oglasa
    public CarAd addCarAd(CarAd carAd) {
        logger.info("addCarAd called");
        return carAdRepository.save(carAd);
    }

    // Pridobitev vseh avtomobilskih oglasov
    public List<CarAd> getAllCarAds() {
        logger.info("getAllCarAds called");
        return carAdRepository.findAll();
    }

    // Pridobitev avtomobilskega oglasa po ID-ju
    public Optional<CarAd> getCarAdById(String id) {
        logger.info("getCarAdById called");
        return carAdRepository.findById(id);
    }

    // Posodobitev avtomobilskega oglasa
    public CarAd updateCarAd(String id, CarAd updatedCarAd) {
        logger.info("updateCarAd called");
        if (carAdRepository.existsById(id)) {
            updatedCarAd.setId(id);
            return carAdRepository.save(updatedCarAd);
        } else {
            logger.error("CarAd with ID " + id + " not found.");
            throw new IllegalArgumentException("CarAd with ID " + id + " not found.");
        }
    }

    // Brisanje avtomobilskega oglasa
    public void deleteCarAd(String id) {
        logger.info("deleteCarAd called");
        carAdRepository.deleteById(id);
    }
}
