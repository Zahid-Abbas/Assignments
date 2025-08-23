package com.example.vehicle_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehicle_service.exception.ResourceNotFoundException;
import com.example.vehicle_service.model.Vehicle;
import com.example.vehicle_service.repository.VehicleRepository;
import com.example.vehicle_service.util.VehicleStatus;
import com.example.vehicle_service.util.VehicleType;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;


    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    
    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        if (!existingVehicle.getVehicleNumber().equals(updatedVehicle.getVehicleNumber())
                && vehicleRepository.existsByVehicleNumber(updatedVehicle.getVehicleNumber())) {
            throw new RuntimeException("Vehicle number already exists!");
        }

        existingVehicle.setVehicleNumber(updatedVehicle.getVehicleNumber());
        existingVehicle.setType(updatedVehicle.getType());
        existingVehicle.setCapacity(updatedVehicle.getCapacity());
        existingVehicle.setStatus(updatedVehicle.getStatus());
        return vehicleRepository.save(existingVehicle);
    }


  
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found id: " + id));
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

 
    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vehicle not found id: " + id);
        }
        vehicleRepository.deleteById(id);
    }


    public List<Vehicle> getByStatus(VehicleStatus status) {
        return vehicleRepository.findByStatus(status);
    }

   
    public List<Vehicle> getByType(VehicleType type) {
        return vehicleRepository.findByType(type);
    }
	
	
	
	
	

}
