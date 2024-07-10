/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entity.Customer;
import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author The user
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean flag = false;
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
//        request.getRequestDispatcher("Controller/CustomerController?username=" + username).forward(request, response);
        List<Customer> list = Customer.gettAll();
        for (Customer i : list) {
            if (i.getPassword().equals(password) && i.getUserName().equals(username)) {
                flag = true;
            }
        }
        if (flag) {
            if (session != null) {
                //store the attributes
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("error", null);
                System.out.println("Username and password id is stored in the session");
            }
            out.write("<html><body><h2>Username and email id is stored in the session, go back and click on \"TestSession\" to test the session</h2></body></html>");
            out.write("<html><body><p>&copy 2024 Sari</p></body></html>");
            response.sendRedirect("welcome.jsp");
        } else {
            session.setAttribute("error", "The username or password is wrong!");
            response.sendRedirect("login.jsp");
        }
    }
}
