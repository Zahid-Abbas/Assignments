package com.example.appointment_service.service;

import com.example.appointment_service.entity.Appointment;
import com.example.appointment_service.exception.AppointmentNotFoundException;
import com.example.appointment_service.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public Appointment create(Appointment appointment) {
        appointment.setStatus(Appointment.Status.BOOKED);
        return repository.save(appointment);
    }

    public Appointment getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + id));
    }

    public List<Appointment> getAll() {
        return repository.findAll();
    }

    public Appointment update(Long id, Appointment updatedAppointment) {
        Appointment existing = getById(id);
        existing.setAppointmentDate(updatedAppointment.getAppointmentDate());
        existing.setStatus(updatedAppointment.getStatus());
        return repository.save(existing);
    }

    public void delete(Long id) {
        Appointment appointment = getById(id);
        repository.delete(appointment);
    }
}
