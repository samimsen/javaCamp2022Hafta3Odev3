package odev3;

import odev3.business.CategoryManager;
import odev3.business.CourseManager;
import odev3.business.InstructorManager;
import odev3.core.logging.DatabaseLogger;
import odev3.core.logging.Logger;
import odev3.core.logging.MailLogger;
import odev3.dataAccess.HibernateCourseDao;
import odev3.dataAccess.JdbcCategoryDao;
import odev3.dataAccess.JdbcInstructorDao;
import odev3.entities.Category;
import odev3.entities.Course;
import odev3.entities.Instructor;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		Category category1 = new Category(1,"Programlama");
		//Category category2 = new Category(2,"Programlama");
		Logger[] loggers = {new DatabaseLogger(), new MailLogger()};
		
		CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(), loggers);
		categoryManager.add(category1);
		//categoryManager.add(category2);
		
		Course course1 = new Course(1,"Java Kursu",39.99);
		//Course course2 = new Course(2,"Java Kursu",20);
		CourseManager courseManager = new CourseManager(new HibernateCourseDao(), loggers);
		courseManager.add(course1);
		//courseManager.add(course2);
		
		Instructor instructor = new Instructor(1,"Ahmet","Mehmet","12121212121");
		InstructorManager instructorManager = new InstructorManager(new JdbcInstructorDao(), loggers);
		instructorManager.add(instructor);
		

	}

}
