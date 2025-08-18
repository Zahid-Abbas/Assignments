package com.example.patient_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.patient_service.entity.Patient;
import com.example.patient_service.exception.PatientNotFoundException;
import com.example.patient_service.repository.PatientRepository;

@Service
public class PatientService {
    
    private final PatientRepository repository;
    
    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }
    
    public Patient addPatient(Patient patient) {
        return repository.save(patient);
    }
    
    public Patient getPatientById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));
    }
    
    public List<Patient> getAllPatients() {
        return repository.findAll();
    }
    
    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient patient = getPatientById(id);
        patient.setName(updatedPatient.getName());
        patient.setEmail(updatedPatient.getEmail());
        patient.setPhone(updatedPatient.getPhone());
        patient.setAddress(updatedPatient.getAddress());
        patient.setInsuranceNumber(updatedPatient.getInsuranceNumber());
        return repository.save(patient);
    }
    
    public void deletePatient(Long id) {
        repository.deleteById(id);
    }
}
