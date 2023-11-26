package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;

public class DeleteDAO {
	public int delete(int id) 
			throws SQLException, ClassNotFoundException {
		
		int processing = 0;
		String sql = "DELETE FROM employees WHERE id = ?";
		try (Connection con = DBConnection.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
			processing = pstmt.executeUpdate();
		}
		return processing;
	}
}
