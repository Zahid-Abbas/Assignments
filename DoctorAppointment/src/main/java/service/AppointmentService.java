package service;

import java.time.LocalDate;

import repository.DoctorRepo;

public class AppointmentService {
	
	private DoctorRepo doctorRepo;
	
	public void setDoctorRepo(DoctorRepo doctorRepo) {
		this.doctorRepo = doctorRepo;
	}
	
	public String book(String doctorId, String dateStr) {
		LocalDate date = LocalDate.parse(dateStr);
		
		if(doctorRepo.isAvailable(doctorId, date)) {
			return "Appointment confirmed";
		} else {
			return "Doctor not available";
		}
	}

}
