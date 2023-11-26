package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.dto.EmployeeDTO;

public class UpdateDAO {
	public EmployeeDTO getEMP(int id) 
			throws SQLException, ClassNotFoundException {
		
		EmployeeDTO emp = new EmployeeDTO();
		String sql = "SELECT * FROM employees WHERE id = ?";
		try (Connection con = DBConnection.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				emp.setId(res.getInt("id"));
				emp.setName(res.getString("name"));
				emp.setDepartment(res.getInt("department"));
				emp.setPost(res.getInt("post"));
			}
			return emp;
		}
	}
	
	public int update(int id, String name, int department, int post) 
			throws SQLException, ClassNotFoundException {
		
		int processing = 0;
		String sql = "UPDATE employees SET name = ?, department = ?, post = ? WHERE id = ?";
		try (Connection con = DBConnection.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, name);
			pstmt.setInt(2, department);
			pstmt.setInt(3, post);
			pstmt.setInt(4, id);
			
			
			processing = pstmt.executeUpdate();
		}
		return processing;
	}
}
