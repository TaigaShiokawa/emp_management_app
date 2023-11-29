package service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginpageFlag;
import model.dao.LoginDAO;
import model.dto.EmployeeDTO;

public class AuthenticationService {

    private LoginDAO loginDAO;

    public AuthenticationService(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    public void authenticateEmployee(EmployeeDTO employee, HttpServletRequest request, HttpServletResponse response) 
            throws IOException, SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        
    	LoginpageFlag loginFlag = new LoginpageFlag(employee.getPost());
    	
        if (loginFlag.flag) {
            processLoginForHigherPost(employee, request, response);
        } else {
            processLoginForLowerPost(employee, request, response);
        }
    }

    private void processLoginForHigherPost(EmployeeDTO employee, HttpServletRequest request, HttpServletResponse response) 
            throws IOException, SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        if (loginDAO.login(employee)) {
            HttpSession session = request.getSession();
            session.setAttribute("myId", loginDAO.getEMPId(employee.getName()));
            response.sendRedirect("emp-list-servlet");
        } else {
            sendLoginError(request, response);
        }
    }

    private void processLoginForLowerPost(EmployeeDTO employee, HttpServletRequest request, HttpServletResponse response) 
            throws IOException, SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        if (loginDAO.login(employee)) {
            HttpSession session = request.getSession();
            session.setAttribute("myId", loginDAO.getEMPId(employee.getName()));
            response.sendRedirect("mypage-servlet");
        } else {
            sendLoginError(request, response);
        }
    }

    private void sendLoginError(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("loginError", "ログインに失敗しました");
        response.sendRedirect("home/login/login.jsp");
    }
}

