package com.web3.carShow.Repository;

import com.web3.carShow.Model.Appointment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
@Repository
public class AppointmentRepository {
    private Connection connection;

    public Appointment createNewInstance(ResultSet resultSet) throws SQLException {
        return new Appointment(
                resultSet.getLong("car_id"),
                resultSet.getString("name"),
                resultSet.getString("firstname"),
                resultSet.getString("email"),
                resultSet.getString("message"),
                resultSet.getString("contact"),
                resultSet.getDate("appointment_date"),
                resultSet.getString("status")
        );
    }





    /*-- CREATE --*/

    public void createAppointment(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO appointment (car_id, name, firstname, email, message, contact, " +
                "appointment_date, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, appointment.getCarId());
            statement.setString(2, appointment.getName());
            statement.setString(3, appointment.getFirstname());
            statement.setString(4, appointment.getEmail());
            statement.setString(5, appointment.getMessage());
            statement.setString(6, appointment.getContact());
            statement.setDate(7, appointment.getAppointmentDate());
            statement.setString(8, appointment.getStatus());

            statement.executeUpdate();
        }
    }



    /*-- READ --*/

    public Appointment getAppointmentById(Long carId) throws SQLException {
        String sql = "SELECT * FROM appointment WHERE car_id = ?;";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setLong(1, carId);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
        }
        return null;
    }




    /*-- UPDATE --*/

    public void updateStatus(Long carId, Appointment appointment) throws SQLException{
        String sql = "UPDATE appointment SET status = ? WHERE car_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, appointment.getStatus());
            statement.setLong(2, carId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

























