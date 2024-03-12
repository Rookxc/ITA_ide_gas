package com.example.idegas.rest;

import com.example.idegas.dto.CarAd;
import com.example.idegas.service.CarAdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/car-ads")
public class CarAdController {

    private final CarAdService carAdService;

    @PostMapping
    public ResponseEntity<CarAd> addCarAd(@RequestBody CarAd carAd) {
        CarAd newCarAd = carAdService.addCarAd(carAd);
        return new ResponseEntity<>(newCarAd, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CarAd>> getAllCarAds() {
        List<CarAd> allCarAds = carAdService.getAllCarAds();
        return new ResponseEntity<>(allCarAds, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarAd> getCarAdById(@PathVariable String id) {
        return carAdService.getCarAdById(id)
                .map(carAd -> new ResponseEntity<>(carAd, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarAd> updateCarAd(@PathVariable String id, @RequestBody CarAd updatedCarAd) {
        CarAd updatedAd = carAdService.updateCarAd(id, updatedCarAd);
        return new ResponseEntity<>(updatedAd, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarAd(@PathVariable String id) {
        carAdService.deleteCarAd(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
