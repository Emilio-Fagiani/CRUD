package it.develhope.CRUD.repository;


import it.develhope.CRUD.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
