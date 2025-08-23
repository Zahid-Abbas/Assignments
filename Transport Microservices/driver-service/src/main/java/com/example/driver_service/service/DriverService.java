package com.example.driver_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.driver_service.exception.ResourceNotFoundException;
import com.example.driver_service.model.Driver;
import com.example.driver_service.repository.DriverRepository;

@Service
public class DriverService {
	
	
	@Autowired
	private DriverRepository driverRepository;
	
	
	 public Driver createDriver(Driver driver) {
	        return driverRepository.save(driver);
	 }
	 
	public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverById(Long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with id: " + id));
    }

    public Driver updateDriver(Long id, Driver driverDetails) {
        Driver driver = getDriverById(id);

        driver.setName(driverDetails.getName());
        driver.setLicenseNumber(driverDetails.getLicenseNumber());
        driver.setPhoneNumber(driverDetails.getPhoneNumber());
        driver.setStatus(driverDetails.getStatus());

        return driverRepository.save(driver);
    }

    public void deleteDriver(Long id) {
        Driver driver = getDriverById(id);
        driverRepository.delete(driver);
    }

}
