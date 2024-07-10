/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entity.*;
import Services.LoanService;
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author The user
 */
@WebServlet(name = "LoansServlet", urlPatterns = {"/LoansServlet"})
public class LoansServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("BookId"));
        String chosen = request.getParameter("choose");
        PrintWriter out = response.getWriter();
        out.write("<h1>Loan update</h1>");

        HttpSession session = request.getSession(true);
        Customer c = Customer.gettAll().stream().filter(p -> p.getPassword().equals(session.getAttribute("password").toString()) && p.getUserName().equals(session.getAttribute("username").toString())).
                findAny().get();
        Integer month = Calendar.MONTH;
        String m = month.toString();
        Loan loan = new Loan(m, c);
        if (chosen.equals("loan")) {
            LoanService.post(loan);
            out.write("<h2 style='text-align:center;>add new loan to the DB (: </h1>");

        } else {
            LoanService.updateLoan(c.getId());
            out.write("<h1>update the loan to be false</h1>");
        }

    }

}
