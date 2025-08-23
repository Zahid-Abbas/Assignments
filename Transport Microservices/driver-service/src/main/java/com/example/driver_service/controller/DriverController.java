package com.example.driver_service.controller;

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

import com.example.driver_service.model.Driver;
import com.example.driver_service.service.DriverService;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
	 	
		@Autowired
	    private DriverService driverService;

	    @PostMapping
	    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
	        return new ResponseEntity<>(driverService.createDriver(driver), HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<Driver>> getAllDrivers() {
	        return ResponseEntity.ok(driverService.getAllDrivers());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
	        return ResponseEntity.ok(driverService.getDriverById(id));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driver) {
	        return ResponseEntity.ok(driverService.updateDriver(id, driver));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
	        driverService.deleteDriver(id);
	        return ResponseEntity.noContent().build();
	    }

}
