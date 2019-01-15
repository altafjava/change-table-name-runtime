package com.javaaltaf.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaaltaf.dao.AttendanceDAO;
import com.javaaltaf.entity.Attendance;

@Service
public class AttendanceService {

	@Autowired
	private AttendanceDAO attendanceDAO;

	public List<Attendance> getAllAttendance() {
		return attendanceDAO.getAllAttendance();
	}
}
