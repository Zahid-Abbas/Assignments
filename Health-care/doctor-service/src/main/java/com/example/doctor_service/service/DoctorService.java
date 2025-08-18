package com.example.doctor_service.service;

import com.example.doctor_service.entity.Doctor;
import com.example.doctor_service.exception.DoctorNotFoundException;
import com.example.doctor_service.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    public Doctor addDoctor(Doctor doctor) {
        // optionally, check duplicate email
        repository.findByEmail(doctor.getEmail()).ifPresent(existing -> {
            // for simplicity, we let DB unique constraint throw or you can throw custom
            // throw new IllegalArgumentException("Doctor with same email already exists");
        });
        return repository.save(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + id));
    }

    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }

    public Doctor updateDoctor(Long id, Doctor updated) {
        Doctor doctor = getDoctorById(id);
        doctor.setName(updated.getName());
        doctor.setSpecialization(updated.getSpecialization());
        doctor.setEmail(updated.getEmail());
        doctor.setPhone(updated.getPhone());
        doctor.setAvailability(updated.getAvailability());
        return repository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        if (!repository.existsById(id)) {
            throw new DoctorNotFoundException("Doctor not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
