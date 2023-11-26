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
import model.dao.RegisterDAO;
import model.dto.EmployeeDTO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register-servlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.sendRedirect("home/register/register.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		int department = Integer.parseInt(request.getParameter("department"));
		int post = Integer.parseInt(request.getParameter("post"));
		
		if(password.length() < 8) {
			request.setAttribute("passError", "8文字以上で入力してください");
			request.getRequestDispatcher("home/register/register.jsp").forward(request, response);
			return;
		}
		
		String hashedPass = null;
		try {
			hashedPass = HashedPW.hashePass(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		EmployeeDTO emp = new EmployeeDTO();
		emp.setName(name);
		emp.setPassword(hashedPass);
		emp.setDepartment(department);
		emp.setPost(post);
		
		RegisterDAO dao = new RegisterDAO();
		
		try {
			int processing = dao.register(emp);
			if(processing == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("success", "登録完了！ ログインへ進んでください");
				response.sendRedirect("home/register/register.jsp");
				return;
			} else {
				response.sendRedirect("home/register/register.jsp");
				return;
			}
		} catch(SQLException | ClassNotFoundException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}
