package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Student;
import util.AppUtild;

class StudentDaoTest {
	private static final String DB_NAME = "coursedb";
	private StudentDao studentDao;

	@BeforeEach
	void setUp() throws Exception {
		studentDao = new StudentDao(AppUtild.initDriver(), DB_NAME);
	}

	@AfterEach
	void tearDown() throws Exception {
		studentDao.close();
		studentDao = null;
	}

//	@Test
//	void testAddStudent() {
//		
//		Student st = new Student ("55", "John Doe", 3.5f);
//		studentDao.addStudent(st);
//		
//	}
	
//	@Test
//	void testAddStudent2() {
//
//		Student st = new Student("66", "Bobby Smith", 3.7f);
//		String id = studentDao.addStudent2(st);
//		String expected = "66";
//		String actual = id;
//		assertEquals(expected, actual);
//		
//	}
	
	@Test
	void testFindStudentByID() {
		String id = "66";
		Student st = studentDao.findStudentByID(id);
		assertNotNull(st);
		assertEquals("Bobby Smith", st.getName());
		assertEquals(3.7f, st.getGpa());
	}
	
	@Test
	void testFindStudentByID_Null() {
		String id = "555";
		Student st = studentDao.findStudentByID(id);
		assertNull(st);
	}
	
	@Test
	void testListOfStudents() {
		List<Student> students = studentDao.listOfStudents(10);
		assertEquals(8, students.size());
		
		students.forEach(st -> System.out.println(st));
	}
	@Test
	void testListStudentOfCS101() {
		List<String> students = studentDao.listStudentsEnrolledInCS101();
		assertEquals(2, students.size());
		students.forEach(st -> System.out.println(st));
	}
	

}
