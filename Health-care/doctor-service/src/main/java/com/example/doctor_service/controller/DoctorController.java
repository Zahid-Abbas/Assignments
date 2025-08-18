package com.example.doctor_service.controller;

import com.example.doctor_service.entity.Doctor;
import com.example.doctor_service.entity.SlotReservation;
import com.example.doctor_service.service.DoctorService;
import com.example.doctor_service.service.SlotReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final SlotReservationService slotReservationService;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public DoctorController(DoctorService doctorService, SlotReservationService slotReservationService) {
        this.doctorService = doctorService;
        this.slotReservationService = slotReservationService;
    }

    // ✅ Add Doctor
    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody Doctor doctor) {
        Doctor saved = doctorService.addDoctor(doctor);
        return ResponseEntity.ok(saved);
    }

    // ✅ Get Doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    // ✅ Get All Doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    // ✅ Update Doctor
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @Valid @RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, doctor));
    }

    // ✅ Delete Doctor
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok(Map.of("message", "Doctor deleted successfully"));
    }

    // ✅ Reserve Slot
    @PostMapping("/{id}/reserve-slot")
    public ResponseEntity<?> reserveSlot(@PathVariable Long id,
                                         @RequestParam String start,
                                         @RequestParam String end) {
        try {
            LocalDateTime startTime = LocalDateTime.parse(start, formatter);
            LocalDateTime endTime = LocalDateTime.parse(end, formatter);

            SlotReservation reservation = slotReservationService.reserveSlot(id, startTime, endTime);
            if (reservation != null) {
                return ResponseEntity.ok(Map.of(
                        "message", "Slot reserved successfully",
                        "doctorId", String.valueOf(reservation.getDoctorId()),
                        "startTime", reservation.getStartTime().toString(),
                        "endTime", reservation.getEndTime().toString(),
                        "status", reservation.getStatus()
                ));
            }
            return ResponseEntity.badRequest().body(Map.of("error", "Slot already reserved or doctor not found"));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid date format. Use yyyy-MM-dd HH:mm"));
        }
    }

    // ✅ Release Slot
    @PostMapping("/{id}/release-slot")
    public ResponseEntity<?> releaseSlot(@PathVariable Long id,
                                         @RequestParam String start) {
        try {
            LocalDateTime startTime = LocalDateTime.parse(start, formatter);
            boolean released = slotReservationService.releaseSlot(id, startTime);
            if (released) {
                return ResponseEntity.ok(Map.of(
                        "message", "Slot released successfully",
                        "doctorId", String.valueOf(id),
                        "startTime", start
                ));
            }
            return ResponseEntity.badRequest().body(Map.of("error", "Slot not found"));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid date format. Use yyyy-MM-dd HH:mm"));
        }
    }
}
