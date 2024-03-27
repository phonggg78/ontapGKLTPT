package util;

import java.net.URI;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

public class AppUtild {
	public static Driver initDriver() {
		
		URI uri = URI.create("neo4j://localhost:7687");
		String us = "neo4j";
		String pw = "12345678";
		
		return GraphDatabase.driver(uri , AuthTokens.basic(us , pw));
	}
}
