package test;

import java.util.List;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Values;
import org.neo4j.driver.types.Node;

import dao.CourseDao;
import dao.StudentDao;
import entity.Course;
import entity.Student;

public class Main {
	public static void main(String[] args) {
		StudentDao studentDao;
		
		String ps = "12345678";
		String us = "neo4j";
		String uri = "neo4j://localhost:7687";
		// Create a connection to the database
		Driver driver = GraphDatabase.driver(uri , AuthTokens.basic(us , ps ));
		
		Session session = driver.session(SessionConfig.forDatabase("coursedb"));
		
		Transaction tx = session.beginTransaction();
		
		
		// Find one course by course id
//		
//		String courseId = "MA301";
//		String query = "MATCH (c: Course) "
//				+ "WHERE c.courseID = $id "
//				+ "RETURN c;";
//		
//		
//		Result result = tx.run(query, Values.parameters("id", courseId));
		
//		Result result = session.executeRead(tx -> tx.run(query, Values.parameters("id", courseId)));
		
//		Record record = result.single();
//		
//		Node node = record.get("c").asNode();
//				
//		Course course = new Course();
//		course.setCourseId(node.get("courseID").asString());
//		course.setName(node.get("name").asString());
//		course.setHours(node.get("hours").asInt());
//		
//		System.out.println(course);
		//Get all courses
		String query = "MATCH (c:Course) RETURN c";
		Result result = tx.run(query);
		List<Course> courses = result.list(r -> {
			Node node = r.get("c").asNode();
			Course course = new Course();
			course.setCourseId(node.get("courseID").asString());
			course.setName(node.get("name").asString());
			course.setHours(node.get("hours").asInt());
			return course;
		});
		System.out.println(courses);
		
//		String query = "MATCH (s:Student)-[:ENROLLED]->(c:Course {courseID: 'CS101'}) RETURN s.name";
//		Result result = tx.run(query);
//		List<String> students = result.list(r -> r.get("s.name").asString());
//		System.out.println(students);
		
	}
}
