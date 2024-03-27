package dao;

import java.util.List;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;

import entity.Course;

public class CourseDao {
	private Driver driver;
	private SessionConfig sessionConfig;
	
	public CourseDao(Driver driver, String dbName) {
        this.driver = driver;
        sessionConfig  = SessionConfig
                .builder()
                .withDatabase(dbName)
                .build();
	}
	/**
	 * Add new course
	 * 
	 * @param course - The course to add
	 */
	public void addCourse(Course course) {
		String query = "CREATE (c:Course {courseID: $id, name: $name, hours: $hours}) ";
		Map<String, Object> pars = Map.of("id", course.getCourseId(), "name", course.getName(),"hours", course.getHours());
		try (Session session = driver.session(sessionConfig)) {
			session.executeWrite(tx -> {
				return tx.run(query, pars).consume();
			});
		}
	}

	/**
	 * C11
	*List all CS and IE courses
	 */
	public List<String> listCoursesCSandIE() {
		String query = "MATCH (c:Course) WHERE c.courseID STARTS WITH 'CS' OR c.courseID STARTS WITH 'IE' RETURN c";
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				return tx.run(query).list(r -> r.get("course_name").asString());
			});
		}
	}
	public void close() {
		driver.close();
    }
}
