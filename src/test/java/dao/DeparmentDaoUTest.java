package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.AppUtild;

class DeparmentDaoUTest {
	private static final String DB_NAME = "coursedb";
	private DepartmentDao deptDao;
	@BeforeEach
	void setUp() throws Exception {
		deptDao = new DepartmentDao(AppUtild.initDriver(), DB_NAME);
	}
	@AfterEach
	void tearDown() throws Exception {
		deptDao.close();
		deptDao = null;
	}
	@Test
	void testListDepartments() {
		assertEquals(5, deptDao.listAllDepartments().size());
	}
	@Test
	void testAllDeanNames() {
		assertEquals(5, deptDao.listAllDeans().size());
	}
	
}
