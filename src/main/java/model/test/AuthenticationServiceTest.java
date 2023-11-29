package model.test;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import model.dao.LoginDAO;
import model.dto.EmployeeDTO;
import service.AuthenticationService;


//よくわからん
public class AuthenticationServiceTest {

    @Mock
    private LoginDAO mockLoginDAO;

    @Mock
    private HttpServletRequest mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    @Mock
    private HttpSession mockSession;

    private AuthenticationService authenticationService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(mockRequest.getSession()).thenReturn(mockSession);
        authenticationService = new AuthenticationService(mockLoginDAO);
    }

    @Test
    public void testAuthenticateEmployeeForHigherPost() throws Exception {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setPost(3); 

        when(mockLoginDAO.login(employee)).thenReturn(true);
        when(mockLoginDAO.getEMPId(employee.getName())).thenReturn(123);

        authenticationService.authenticateEmployee(employee, mockRequest, mockResponse);

        verify(mockSession).setAttribute("myId", "123");
        verify(mockResponse).sendRedirect("emp-list-servlet");
    }

    @Test
    public void testAuthenticateEmployeeForLowerPost() throws Exception {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setPost(1); // lower post

        when(mockLoginDAO.login(employee)).thenReturn(true);
        when(mockLoginDAO.getEMPId(employee.getName())).thenReturn(123);

        authenticationService.authenticateEmployee(employee, mockRequest, mockResponse);

        verify(mockSession).setAttribute("myId", "123");
        verify(mockResponse).sendRedirect("mypage-servlet");
    }

    @Test
    public void testLoginError() throws Exception {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setPost(1); 

        when(mockLoginDAO.login(employee)).thenReturn(false);

        authenticationService.authenticateEmployee(employee, mockRequest, mockResponse);

        verify(mockSession).setAttribute("loginError", "ログインに失敗しました");
        verify(mockResponse).sendRedirect("home/login/login.jsp");
    }
}
