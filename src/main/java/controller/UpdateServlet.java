package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import content.Parameters;
import model.dao.UpdateDAO;
import model.dto.EmployeeDTO;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update-servlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int empId = Integer.parseInt(request.getParameter(Parameters.EMP_ID));
		
		EmployeeDTO emp = new EmployeeDTO();
		UpdateDAO dao = new UpdateDAO();
		
		try {
			emp = dao.getEMP(empId);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("WEB-INF/update.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int empId = Integer.parseInt(request.getParameter(Parameters.EMP_ID));
		String name = request.getParameter("name");
		int department = Integer.parseInt(request.getParameter("department"));
		int post = Integer.parseInt(request.getParameter("post"));
		
//		EmployeeDTO emp = new EmployeeDTO();
//		emp.setName(name);
//		emp.setDepartment(department);
//		emp.setPost(post);
//		emp.setId(empId);
		UpdateDAO dao = new UpdateDAO();
		try {
			dao.update(empId, name, department, post);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		response.sendRedirect("emp-list-servlet");
	}

}
