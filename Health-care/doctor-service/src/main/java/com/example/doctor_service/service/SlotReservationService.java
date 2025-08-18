package com.example.doctor_service.service;

import com.example.doctor_service.entity.SlotReservation;
import com.example.doctor_service.entity.SlotStatus;
import com.example.doctor_service.repository.SlotReservationRepository;
import com.example.doctor_service.service.DoctorService; // optional - if you have a service to validate doctor
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SlotReservationService {

    private final SlotReservationRepository repository;
    private final DoctorService doctorService; // optional; remove if you don't have it

    public SlotReservationService(SlotReservationRepository repository, DoctorService doctorService) {
        this.repository = repository;
        this.doctorService = doctorService;
    }

    /**
     * Try to reserve a slot.
     * Returns the saved SlotReservation when successful, or null when conflict / doctor not found.
     */
    @Transactional
    public SlotReservation reserveSlot(Long doctorId, LocalDateTime startTime, LocalDateTime endTime) {
        // Optional: validate doctor exists via DoctorService
        try {
            doctorService.getDoctorById(doctorId); // if not found, let it throw or handle below
        } catch (Exception ex) {
            return null; // doctor doesn't exist
        }

        // Check for overlapping reservation
        boolean conflict = repository
                .existsByDoctorIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(doctorId, endTime, startTime);

        if (conflict) {
            return null; // overlap detected
        }

        SlotReservation reservation = new SlotReservation();
        reservation.setDoctorId(doctorId);
        reservation.setStartTime(startTime);
        reservation.setEndTime(endTime);
        reservation.setStatus(SlotStatus.RESERVED);

        return repository.save(reservation);
    }

    /**
     * Release (cancel) a reservation identified by doctorId + startTime.
     * Returns true if a reservation was found and updated; false otherwise.
     */
    @Transactional
    public boolean releaseSlot(Long doctorId, LocalDateTime startTime) {
        Optional<SlotReservation> opt = repository.findByDoctorIdAndStartTime(doctorId, startTime);
        if (opt.isPresent()) {
            SlotReservation reservation = opt.get();
            // only cancel if currently reserved
            if (reservation.getStatus() == SlotStatus.RESERVED) {
                reservation.setStatus(SlotStatus.CANCELLED);
                repository.save(reservation);
                return true;
            }
            // if status was AVAILABLE or CANCELLED already, treat as not releasable
            return false;
        }
        return false;
    }
}
