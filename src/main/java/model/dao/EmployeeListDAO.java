package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import model.dto.EmployeeDTO;

public class EmployeeListDAO {
	public List<EmployeeDTO> empList() 
			throws SQLException, ClassNotFoundException {
		
		List<EmployeeDTO> empList = new ArrayList<>();
		String sql = "SELECT * FROM employees WHERE post > 2";
		try (Connection con = DBConnection.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				String password = res.getString("password");
				int department = res.getInt("department");
				int post = res.getInt("post");
				
				empList.add(new EmployeeDTO(id, name, password, department, post));
			}
		}
		return empList;
	}
	
	public EmployeeDTO myPage(EmployeeDTO DTO) 
			throws SQLException, ClassNotFoundException {
		
		EmployeeDTO emp = new EmployeeDTO();
		String sql = "SELECT * FROM employees WHERE post < 3";
		try (Connection con = DBConnection.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int id = res.getInt("id");
				String name = res.getString("name");
				String password = res.getString("password");
				int department = res.getInt("department");
				int post = res.getInt("post");
				
				emp = new EmployeeDTO(id, name, password, department, post);
			}
		}
		return emp;
	}

}
