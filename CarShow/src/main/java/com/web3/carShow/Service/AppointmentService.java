package com.web3.carShow.Service;

import com.web3.carShow.Model.Appointment;
import com.web3.carShow.Repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@AllArgsConstructor
public class AppointmentService {
    private AppointmentRepository appointmentRepository;



    /*-- CREATE --*/

    public Appointment createAppointment(Appointment appointment) {
        try {
            appointmentRepository.createAppointment(appointment);
            return appointment;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }



    /*-- READ --*/

    public Appointment getAppointmentById(Long carId){
        try {
            return this.appointmentRepository.getAppointmentById(carId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    /*-- UPDATE --*/

    public Appointment updateAppointmentStatus(Long carId, Appointment appointment){
        try {
            appointment.setCarId(carId);
            appointmentRepository.updateStatus(carId, appointment);
            return appointment;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
