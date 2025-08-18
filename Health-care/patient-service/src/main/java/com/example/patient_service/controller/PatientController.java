package com.example.patient_service.controller;

import com.example.patient_service.entity.Patient;
import com.example.patient_service.service.PatientService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    
    private final PatientService service;
    
    public PatientController(PatientService service) {
        this.service = service;
    }
    
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return service.addPatient(patient);
    }
    
    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Long id) {
        return service.getPatientById(id);
    }
    
    @GetMapping
    public List<Patient> getAllPatients() {
        return service.getAllPatients();
    }
    
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return service.updatePatient(id, patient);
    }
    
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        service.deletePatient(id);
        return "Patient deleted successfully";
    }
}
