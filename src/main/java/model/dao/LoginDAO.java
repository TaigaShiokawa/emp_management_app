package model.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.HashedPW;
import model.dto.EmployeeDTO;

public class LoginDAO {
	public boolean login(EmployeeDTO emp) 
			throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
		
		boolean status = false;
		String sql = "SELECT * FROM employees WHERE name = ? AND password = ? AND post = ?";
		
		String hashedPass = HashedPW.hashePass(emp.getPassword());
		try (Connection con = DBConnection.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, hashedPass);
			pstmt.setInt(3, emp.getPost());
			
			ResultSet res = pstmt.executeQuery(); //検索の結果を持っている
			status = res.next();
		}
		return status;
	}
	
	public int getEMPId(String name) //sessionで保管しておきたいidの設定
			throws SQLException, ClassNotFoundException {
		
		int empId = -1;
		String sql = "SELECT id FROM employees WHERE name = ?";
		try (Connection con = DBConnection.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, name);
			ResultSet res = pstmt.executeQuery();
			if(res.next()) {
				empId = res.getInt("id");
			}
			return empId;
		}
	}
}
