package com.capstone.login;

import java.sql.*;

public class AdminDAO {
              
              public Admin checkLogin(String email, String password) throws SQLException,
    ClassNotFoundException {
String jdbcURL = "jdbc:mysql://localhost:3306/capstone";
String dbUser = "root";
String dbPassword = "mysql";

Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
String sql = "SELECT * FROM admin WHERE email = ? and password = ?";
PreparedStatement statement = connection.prepareStatement(sql);
statement.setString(1, email);
statement.setString(2, password);

ResultSet result = statement.executeQuery();

Admin admin = null;

if (result.next()) {
    admin = new Admin();
    admin.setFullName(result.getString("fullname"));
    admin.setEmail(email);
}

connection.close();

return admin;
              }
}

