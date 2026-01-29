package com.vastpro.onlineexam.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Class Name: DBConnection
 *
 * Description:
 * This utility class provides methods to manage database connections
 * for the Online Exam system. It handles creating connections to the
 * PostgreSQL database and provides helper methods to close connections
 * and statements safely.
 */
public class DBConnection {
	private static final Logger logger = LogManager.getLogger(DBConnection.class);
    /**
     * Establishes and returns a new database connection.
     *
     * @return a Connection object connected to the PostgreSQL database
     * @throws SQLException if a database access error occurs
     */
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/onlineexam_db",
		//		"postgres", "postgres");
		Connection conn = HikariConnection.getDataSource().getConnection();
		logger.debug("database connection is created ");
		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
