package model.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;
import model.HashedPW;
import model.dto.EmployeeDTO;

public class RegisterDAO {
	public int register(EmployeeDTO emp) 
			throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
		
		int processing = 0;
		String sql = "INSERT INTO employees (name, password, department, post) VALUES (?, ?, ?, ?)";
		String hashedPass = HashedPW.hashePass(emp.getPassword());
		
		try (Connection con = DBConnection.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, hashedPass);
			pstmt.setInt(3, emp.getDepartment());
			pstmt.setInt(4, emp.getPost());
			
			processing = pstmt.executeUpdate();
		}
		return processing;
	}

}
