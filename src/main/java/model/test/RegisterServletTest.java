package model.test;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import controller.RegisterServlet;
import model.dao.RegisterDAO;
import model.dto.EmployeeDTO;

//よくわからん
public class RegisterServletTest {

    @Mock
    private HttpServletRequest mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    @Mock
    private HttpSession mockSession;

    @Mock
    private RegisterDAO mockRegisterDAO;

    private RegisterServlet registerServlet;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        registerServlet = new RegisterServlet();
        registerServlet.setRegisterDAO(mockRegisterDAO); 
        when(mockRequest.getSession()).thenReturn(mockSession);
    }
    

    @Test
    public void testDoPostSuccessfulRegistration() throws Exception {
        when(mockRequest.getParameter("name")).thenReturn("tanaka");
        when(mockRequest.getParameter("password")).thenReturn("password123");
        when(mockRequest.getParameter("department")).thenReturn("1");
        when(mockRequest.getParameter("post")).thenReturn("2");

        when(mockRegisterDAO.register(any(EmployeeDTO.class))).thenReturn(1);

        registerServlet.doPost(mockRequest, mockResponse);

        verify(mockSession).setAttribute("success", "登録完了！ ログインへ進んでください");
        verify(mockResponse).sendRedirect("home/register/register.jsp");
    }
    
    @Test(expected = SQLException.class)
    public void testDoPostSQLException() throws Exception {
       
        when(mockRequest.getParameter("name")).thenReturn("tanaka");
        when(mockRequest.getParameter("password")).thenReturn("pass123");
        when(mockRequest.getParameter("department")).thenReturn("1");
        when(mockRequest.getParameter("post")).thenReturn("2");

        when(mockRegisterDAO.register(any(EmployeeDTO.class))).thenThrow(new SQLException());

        registerServlet.doPost(mockRequest, mockResponse);
    }


    @Test
    public void testDoPostPasswordTooShort() throws Exception {
        when(mockRequest.getParameter("name")).thenReturn("John Doe");
        when(mockRequest.getParameter("password")).thenReturn("pass");
        when(mockRequest.getParameter("department")).thenReturn("1");
        when(mockRequest.getParameter("post")).thenReturn("2");

        registerServlet.doPost(mockRequest, mockResponse);

        verify(mockRequest).setAttribute("passError", "8文字以上でお願いします！");
        
        verify(mockResponse).sendRedirect("home/register/register.jsp");
    }
}
