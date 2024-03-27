package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.AppUtild;

class CourseDaoTest {
	private static final String DB_NAME = "coursedb";
	private CourseDao courseDao;
	@BeforeEach
	void setUp() throws Exception {
		courseDao = new CourseDao(AppUtild.initDriver(), DB_NAME);
	}
	
	@Test
	void testListCourses() {
		assertEquals(5, courseDao.listCoursesCSandIE().size());
	}
	@AfterEach
	void tearDown() throws Exception {
		courseDao.close();
		courseDao = null;
	}

}
