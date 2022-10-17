package odev3.business;

import java.util.ArrayList;
import java.util.List;

import odev3.core.logging.Logger;
import odev3.dataAccess.CourseDao;
import odev3.entities.Course;

public class CourseManager {

	private CourseDao courseDao;
	private Logger[] loggers;

	public CourseManager(CourseDao courseDao, Logger[] loggers) {
		this.courseDao = courseDao;
		this.loggers = loggers;
	}

	List<Course> courses = new ArrayList<>();

	public void add(Course course) throws Exception {

		for (Course currentCourse : courses) {

			if (currentCourse.getName().equals(course.getName())) {
				throw new Exception("Kurs ismi tekrar edemez");
			}

		}

		if (course.getPrice() < 0) {
			throw new Exception("Bir kursun fiyatı 0 dan kucuk olamaz");
		}

		courses.add(course);
		this.courseDao.add(course);

		for (Logger logger : loggers) {
			logger.log(course.getName());
		}

	}

}
