package com.web3.carShow.Repository;

import com.web3.carShow.Model.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
@AllArgsConstructor
public class CarRepository {
    private Connection connection;


    public Car createNewInstance(ResultSet resultSet) throws SQLException {
        return new Car(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getString("brand"),
                resultSet.getString("model"),
                resultSet.getDouble("price"),
                resultSet.getString("color"),
                resultSet.getString("motor_type"),
                resultSet.getString("power"),
                resultSet.getInt("place_number"),
                resultSet.getString("status"),
                resultSet.getString("type")
        );
    }


        /* -- CREATE -- */

    public void createCar(Car car) throws SQLException {
        String sql = "INSERT INTO car (name, description, brand, model, price, color, motor_type, power, place_number,status, type) \n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?);";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, car.getName());
            statement.setString(2, car.getDescription());
            statement.setString(3, car.getBrand());
            statement.setString(4, car.getModel());
            statement.setDouble(5, car.getPrice());
            statement.setString(6, car.getColor());
            statement.setString(7, car.getMotorType());
            statement.setString(8, car.getPower());
            statement.setInt(9, car.getPlaceNumber());
            statement.setString(10, car.getStatus());
            statement.setString(11, car.getType());

            statement.executeUpdate();
        }
    }



    /* -- READ -- */

    public List<Car> getAllCar() throws SQLException {
        String sql = "SELECT * FROM car";
        List<Car> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            list.add(createNewInstance(resultSet));
        }
        return list;
    }

    public Car getCarById(Long id) throws SQLException {
        String sql = "SELECT * FROM car WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
        }
        return null;
    }



    /*-- UPDATE --*/

    public void updateCarInfo (Car car, Long id) throws SQLException {
        String sql = "UPDATE car SET name = ?, description = ?, brand = ?, model = ?, price = ?, color = ?, \n" +
                " motor_type = ?, power = ?, place_number = ?, status = ?, type = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, car.getName());
            statement.setString(2, car.getDescription());
            statement.setString(3, car.getBrand());
            statement.setString(4, car.getModel());
            statement.setDouble(5, car.getPrice());
            statement.setString(6, car.getColor());
            statement.setString(7, car.getMotorType());
            statement.setString(8, car.getPower());
            statement.setInt(9, car.getPlaceNumber());
            statement.setString(10, car.getStatus());
            statement.setString(11, car.getType());
            statement.setLong(12, id);
            statement.executeUpdate();
        }
    }


    /*-- DELETE --*/

    public void deleteCarById(Long id) throws SQLException {
        String sql = "DELETE FROM car WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeQuery();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteAllCar() throws SQLException {
        String sql = "DELETE FROM car";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.executeQuery();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }



}