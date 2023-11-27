package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*DB設計
 * 
 *  create table employees (
    -> id int auto_increment primary key,
    -> name varchar(20) not null,
    -> password varchar(255) not null,
    -> department int not null,
    -> post int not null,
    -> FOREIGN KEY (department) REFERENCES departments(id),
    -> FOREIGN KEY (post) REFERENCES posts(id)
    -> );

 * create table posts (
    -> id int not null auto_increment primary key,
    -> post_id int not null
    -> );
 * 
 *  create table departments (
    -> id int not null auto_increment primary key,
    -> department_id int not null
    -> );
 * 
 * */

public class DBConnection {
	public static Connection getConnection() 
			throws SQLException, ClassNotFoundException {
		
		final String URL = "jdbc:mysql://localhost/emp_management_db";
		final String USER = "root";
		final String PASS = "";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		return con;
	}

}
