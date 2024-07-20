package com.shashi.srv;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shashi.beans.UserBean;
import com.shashi.service.impl.UserServiceImpl;

@WebServlet("/RegisterSrv")
public class RegisterSrv extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        String userName = request.getParameter("username");
        String mobile = request.getParameter("mobile");
        String emailId = request.getParameter("email");
        String address = request.getParameter("address");
        String pinCode = request.getParameter("pincode");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String status = "";

        // Validate inputs
        if (!validateInput(userName, mobile, emailId, address, pinCode, password, confirmPassword)) {
            status = "Invalid input data!";
        } else if (password != null && password.equals(confirmPassword)) {
            Long mobileNo = Long.parseLong(mobile);
            int pinCodeNum = Integer.parseInt(pinCode);

            UserBean user = new UserBean(userName, mobileNo, emailId, address, pinCodeNum, password);

            UserServiceImpl dao = new UserServiceImpl();

            status = dao.registerUser(user);
        } else {
            status = "Passwords do not match!";
        }

        RequestDispatcher rd = request.getRequestDispatcher("register.jsp?message=" + status);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private boolean validateInput(String userName, String mobile, String emailId, String address, String pinCode, String password, String confirmPassword) {
        if (userName == null || userName.trim().isEmpty() || userName.length() > 50) {
            return false;
        }
        if (mobile == null || !mobile.matches("\\d{10}")) {
            return false;
        }
        if (emailId == null || !emailId.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            return false;
        }
        if (address == null || address.trim().isEmpty() || address.length() > 100) {
            return false;
        }
        if (pinCode == null || !pinCode.matches("\\d{6}")) {
            return false;
        }
        if (password == null || password.length() < 6 || password.length() > 20) {
            return false;
        }
        if (confirmPassword == null || !password.equals(confirmPassword)) {
            return false;
        }
        return true;
    }
}
