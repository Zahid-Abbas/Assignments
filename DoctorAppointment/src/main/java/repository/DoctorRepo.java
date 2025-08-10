package repository;

import java.time.LocalDate;
import java.util.*;

public class DoctorRepo {
	private Map<String, List<String>> doctorSchedule = new HashMap<>();
	
	public void setDoctorSchedule(Map<String, List<String>> doctorSchedule) {
		this.doctorSchedule = doctorSchedule;
	}
	
	public boolean isAvailable(String doctorId, LocalDate date) {
		List<String> dates = doctorSchedule.get(doctorId);
		return dates != null && dates.contains(date.toString());
	}

}
