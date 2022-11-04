package it.develhope.CRUD.controller;

import it.develhope.CRUD.entity.Car;
import it.develhope.CRUD.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepository.saveAndFlush(car);
    }

    @GetMapping
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable Long id) {
        if (!carRepository.existsById(id)) {
            return Optional.of(new Car());
        } else
            return carRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Car putCar(@PathVariable Long id, @RequestBody Car car) {
        if (carRepository.existsById(id)) {
            car.setId(id);
            Car putCar = carRepository.save(car);
            return putCar;
        } else
            return new Car();
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        if (!carRepository.existsById(id)) {
            System.out.println(HttpStatus.CONFLICT);
        } else
            carRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteCars() {
        carRepository.deleteAll();
    }


}
