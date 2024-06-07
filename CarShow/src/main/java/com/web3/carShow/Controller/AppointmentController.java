package com.web3.carShow.Controller;

import com.web3.carShow.Model.Appointment;
import com.web3.carShow.Service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AppointmentController {
    private AppointmentService appointmentService;




    /*-- GET REQUEST --*/

    /* Get appointment by carId */
    @GetMapping("/appointment/{carId}")
    public Appointment getAppointmentById(@PathVariable Long carId) {
        return this.appointmentService.getAppointmentById(carId);
    }



    /*-- PUT REQUEST --*/

    @PutMapping("/appointment/{carId}")
    public Appointment updateAppointmentStatus(Long carId, Appointment appointment) {
        return this.appointmentService.updateAppointmentStatus(carId, appointment);
    }



    /*-- POST REQUEST --*/

    /* Create appointment */
    @PostMapping("/appointment")
    public Appointment createAppointment(Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }
}
