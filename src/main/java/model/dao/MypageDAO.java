package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.dto.EmployeeDTO;

public class MypageDAO {
	public EmployeeDTO my(int myId) 
			throws SQLException, ClassNotFoundException {
		
		EmployeeDTO my = new EmployeeDTO();
		String sql = "SELECT * FROM employees WHERE id = ?";
		try (Connection con = DBConnection.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, myId);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				String password = res.getString("password");
				int department = res.getInt("department");
				int post = res.getInt("post");
				
				my = new EmployeeDTO(id, name, password, department, post);
			}
		}
		return my;
	}
}
