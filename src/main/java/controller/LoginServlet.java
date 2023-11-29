package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HashedPW;
import model.dao.LoginDAO;
import model.dto.EmployeeDTO;
import service.AuthenticationService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("home/login/login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    
	    request.setCharacterEncoding("UTF-8");
	    String name = request.getParameter("name");
	    String password = request.getParameter("password");
	    String hashedPass = null;
	    int post = Integer.parseInt(request.getParameter("post"));
	    
	    try {
	        hashedPass = HashedPW.hashPass(password);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    
	    EmployeeDTO emp = new EmployeeDTO();
	    emp.setName(name);
	    emp.setPassword(hashedPass);
	    emp.setPost(post);
	    LoginDAO dao = new LoginDAO();
	    
	    AuthenticationService authService = new AuthenticationService(dao);
	    
	    try {
	        authService.authenticateEmployee(emp, request, response);
	    } catch(SQLException | ClassNotFoundException | NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	}
}
