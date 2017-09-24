package com.example.bot.spring;

import lombok.extern.slf4j.Slf4j;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.net.URISyntaxException;
import java.net.URI;

@Slf4j
public class SQLDatabaseEngine extends DatabaseEngine {
	@Override
	String search(String text) throws Exception {
		//Write your code here
		Connection connection = this.getConnection();
		PreparedStatement stmt = connection.prepareStatement(
//				"SELECT keyword, response, hits FROM responsetable WHERE keyword like concat ('%', ?, '%')"
				"SELECT keyword, response, hits FROM responsetable WHERE POSITION(LOWER(keyword) in LOWER(?)) > 0" 
				);
		stmt.setString(1, text);
		
		String keyword = null;
		String response = null;
		int hits = -1;
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			keyword = rs.getString(1);
			response = rs.getString(2);
			hits = rs.getInt(3);
			System.out.println(keyword  + " | " + response + " | " + hits);
		}
		
		rs.close();
		stmt.close();
		
		
		if(keyword != null && hits != -1) {
			PreparedStatement updateStmt = connection.prepareStatement(
					"UPDATE responsetable SET hits=? WHERE responsetable.keyword=?"
					);
			updateStmt.setInt(1, hits+1);
			updateStmt.setString(2, keyword);
			
			System.out.println("1." + response);	
			updateStmt.executeUpdate();
			updateStmt.close();
		}
		
		System.out.println("2." + response);
		
		
		connection.close();
		return response;
	}
	
	
	private Connection getConnection() throws URISyntaxException, SQLException {
		Connection connection;
		URI dbUri = new URI(System.getenv("DATABASE_URL"));

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() +  "?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

		log.info("Username: {} Password: {}", username, password);
		log.info ("dbUrl: {}", dbUrl);
		
		connection = DriverManager.getConnection(dbUrl, username, password);

		return connection;
	}

}
