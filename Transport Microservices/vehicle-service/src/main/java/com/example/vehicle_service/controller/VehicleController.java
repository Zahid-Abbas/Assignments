package com.example.vehicle_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehicle_service.model.Vehicle;
import com.example.vehicle_service.service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	 @PostMapping
	    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
	        return new ResponseEntity<>(vehicleService.createVehicle(vehicle), HttpStatus.CREATED);
	    }
	 
	 @GetMapping
	    public ResponseEntity<List<Vehicle>> getAllVehicles() {
	        return ResponseEntity.ok(vehicleService.getAllVehicles());
	    }
	 
	 

	    @PutMapping("/{id}")
	    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id,@RequestBody Vehicle vehicle) {
	        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicle));
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Vehicle> getVehicle(@PathVariable Long id) {
	        return ResponseEntity.ok(vehicleService.getVehicleById(id));
	    }    

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
	    	vehicleService.deleteVehicle(id);
	        return ResponseEntity.noContent().build();
	    }
	

}
