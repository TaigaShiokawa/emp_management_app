package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HashedPW;
import model.dao.EmployeeAddDAO;
import model.dto.EmployeeDTO;

/**
 * Servlet implementation class EmployeeAddServlet
 */
@WebServlet("/emp-add-servlet")
public class EmployeeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/emp-add.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		int department = Integer.parseInt(request.getParameter("department"));
		int post = Integer.parseInt(request.getParameter("post"));
		
		String hashedPass = null;
		try {
			hashedPass = HashedPW.hashePass(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		EmployeeDTO emp = new EmployeeDTO();
		EmployeeAddDAO dao = new EmployeeAddDAO();
		
		emp.setName(name);
		emp.setPassword(hashedPass);
		emp.setDepartment(department);
		emp.setPost(post);
		
		try {
			int insert = dao.insert(emp);
			if(insert == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("success", "追加完了！");
			}
		} catch(SQLException | ClassNotFoundException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/emp-add.jsp").forward(request, response);
	}

}
