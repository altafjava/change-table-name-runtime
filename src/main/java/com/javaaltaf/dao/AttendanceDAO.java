package com.javaaltaf.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaaltaf.config.CustomInterceptor;
import com.javaaltaf.entity.Attendance;

@Repository
public class AttendanceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Attendance> getAllAttendance() {
//		Session session = sessionFactory.withOptions().interceptor(new HibernateInterceptor()).openSession();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Attendance");
		List<Attendance> attendanceList = query.list();
		return attendanceList;
	}
}
