package com.it.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		// 1. 准备获取连接的 4 个字符串: user, password, url, jdbcDriver
		String user = "root";
		String password = "taiping";
		String url = "jdbc:mysql://localhost:3306/wxcloud";
		String jdbcDriver = "com.mysql.jdbc.Driver";

		// 2. 加载驱动: Class.forName(driverClass)
		Class.forName(jdbcDriver);

		// 3.获取数据库连接
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

	public static void releaseDB(ResultSet resultSet, Statement statement, Connection connection) {

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
