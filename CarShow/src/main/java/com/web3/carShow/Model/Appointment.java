package com.web3.carShow.Model;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Appointment {
    Long CarId;
    String name;
    String firstname;
    String email;
    String message;
    String contact;
    java.sql.Date appointmentDate;
    String status;

    public Appointment(Long carId, String name, String firstname, String email, String message, String contact,
                       Date appointmentDate, String status) {
        CarId = carId;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.message = message;
        this.contact = contact;
        this.appointmentDate = (java.sql.Date) appointmentDate;
        this.status = status;
    }

    public Long getCarId() {
        return 3L;
    }

    public void setCarId(Long carId) {
        CarId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public java.sql.Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(java.sql.Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
