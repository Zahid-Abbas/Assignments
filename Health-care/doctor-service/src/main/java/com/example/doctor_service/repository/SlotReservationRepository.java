package com.example.doctor_service.repository;

import com.example.doctor_service.entity.SlotReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface SlotReservationRepository extends JpaRepository<SlotReservation, Long> {

    boolean existsByDoctorIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
            Long doctorId, LocalDateTime endTime, LocalDateTime startTime);

    Optional<SlotReservation> findByDoctorIdAndStartTime(Long doctorId, LocalDateTime startTime);
}
