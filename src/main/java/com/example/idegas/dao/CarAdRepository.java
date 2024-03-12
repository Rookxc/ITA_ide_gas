package com.example.idegas.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.idegas.dto.CarAd;
import java.util.List;

public interface CarAdRepository extends MongoRepository<CarAd, String> {
    // Poišči vse avtomobilske oglase za določeno znamko
    List<CarAd> findByBrand(String brand);

    // Poišči vse avtomobilske oglase za določen model
    List<CarAd> findByModel(String model);

    // Poišči vse avtomobilske oglase, ki so starejši od določenega leta
    List<CarAd> findByYearLessThan(int year);

    // Poišči vse avtomobilske oglase, ki so mlajši od določenega leta
    List<CarAd> findByYearGreaterThan(int year);
}
