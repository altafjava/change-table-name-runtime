package com.javaaltaf.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javaaltaf.entity.Attendance;
import com.javaaltaf.service.AttendanceService;

@RestController
public class AttendanceController {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private AttendanceService attendanceService;

	//@PostConstruct
	private void save() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Attendance attendance = new Attendance();
		attendance.setCheckin(new Date());
		attendance.setCheckout(new Date());
		Random random = new Random();
		attendance.setDeviceLogId("JANUARY-DEV-LOG-ID-" + random.nextInt(101));
		attendance.setEmpId("EMP-" + random.nextInt(101));
		session.save(attendance);
		transaction.commit();

	}

	@GetMapping("/attendance")
	public List<Attendance> getAllAttendance() {
		return attendanceService.getAllAttendance();
	}
}
