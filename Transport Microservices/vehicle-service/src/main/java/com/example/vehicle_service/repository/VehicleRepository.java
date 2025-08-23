package com.example.vehicle_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vehicle_service.model.Vehicle;
import com.example.vehicle_service.util.VehicleStatus;
import com.example.vehicle_service.util.VehicleType;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	Optional<Vehicle> findByVehicleNumber(String vehicleNumber);
    List<Vehicle> findByStatus(VehicleStatus status);
    List<Vehicle> findByType(VehicleType type);
    boolean existsByVehicleNumber(String vehicleNumber);
}
