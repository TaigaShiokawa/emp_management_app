package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MypageDAO;
import model.dto.EmployeeDTO;

/**
 * Servlet implementation class TopPostServlet
 */
@WebServlet("/top-post-mypage-servlet")
public class TopPostMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int myId = (int)session.getAttribute("myId");
		
		EmployeeDTO my = new EmployeeDTO();
		MypageDAO dao = new MypageDAO();
		
		
		try {
			my = dao.my(myId);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("my", my);
		
		request.getRequestDispatcher("WEB-INF/top-post-mypage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
