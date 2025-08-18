package com.example.medical_record_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.medical_record_service.entity.MedicalRecord;
import com.example.medical_record_service.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository repository;

    public MedicalRecordService(MedicalRecordRepository repository) {
        this.repository = repository;
    }

    public MedicalRecord create(MedicalRecord record) {
        return repository.save(record);
    }

    public List<MedicalRecord> getAll() {
        return repository.findAll();
    }

    public MedicalRecord getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Record not found"));
    }

    public List<MedicalRecord> getByPatientId(Long patientId) {
        return repository.findByPatientId(patientId);
    }

    public MedicalRecord update(Long id, MedicalRecord updatedRecord) {
        MedicalRecord existing = getById(id);
        existing.setVisitDate(updatedRecord.getVisitDate());
        existing.setDiagnosis(updatedRecord.getDiagnosis());
        existing.setPrescriptions(updatedRecord.getPrescriptions());
        existing.setTestResults(updatedRecord.getTestResults());
        existing.setNotes(updatedRecord.getNotes());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
