package com.web3.carShow.Service;

import com.web3.carShow.Model.Car;
import com.web3.carShow.Repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private CarRepository carRepository;



    /*-- CREATE --*/

    public Car createCar(Car car){
        try {
            carRepository.createCar(car);
            return car;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



    /*-- READ --*/

    public List<Car> getAllCar(){
        try {
            return this.carRepository.getAllCar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Car getCarById(Long id) {
        try {
            return this.carRepository.getCarById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



    /*-- UPDATE --*/

    public Car updateCarInfo(Car car, Long id){
        try {
            car.setId(id);
            carRepository.updateCarInfo(car, id);
            return car;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



    /*-- DELETE --*/

    public String deleteCarById(Long id){
        try {
            carRepository.deleteCarById(id);
            return "Car with id = " + id + " are deleted";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String deleteAllcar() {
        try {
            carRepository.deleteAllCar();
            return "All car are deleted";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
