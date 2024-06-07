package com.web3.carShow.Controller;

import com.web3.carShow.Model.Car;
import com.web3.carShow.Service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarController {
    private CarService carService;

    /*-- GET REQUEST --*/

    /* Get the list of all cars */
    @GetMapping("/car")
    public List<Car> getAllCar() {
        return this.carService.getAllCar();
    }

    /* Get a car by his id */
    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable Long id) {
        return this.carService.getCarById(id);
    }



    /*-- PUT REQUEST --*/

    /* Update all car information */
    @PutMapping("/car/{id}")
    public Car updateCarInfo(@RequestBody Car car, @PathVariable Long id) {
        return this.carService.updateCarInfo(car, id);
    }



    /*-- POST REQUEST --*/

    /* Create a new car */
    @PostMapping("/car")
    public Car createCar(@RequestBody Car car) {
        return this.carService.createCar(car);
    }



    /*-- DELETE MAPING --*/

    /* Delete all car */
    @DeleteMapping("/car/all")
    public String deleteAllCar() {
        return this.carService.deleteAllcar();
    }

    /* Delete one car by his id */
    @DeleteMapping("/car/{id}")
    public String deleteCarById(@PathVariable Long id) {
        return this.carService.deleteCarById(id);
    }

}
