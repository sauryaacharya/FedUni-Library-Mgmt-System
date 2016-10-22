/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.RegistrationBean;
import beans.RegistrationBeanLocal;
import entity.Users;
import entity.UsersFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Validator;
import utils.RegistrationValidator;

/**
 *
 * @author saurya
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    
    @EJB
    private UsersFacadeLocal usersFacade;
    
    @EJB
    private RegistrationBeanLocal registrationBean;
    

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        
        String firstName = request.getParameter("firstName");
        String middleName = (request.getParameter("middleName").equals("")) ? " " : request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String emailId = request.getParameter("emailId");
        String password = request.getParameter("password");
        String phoneNum = request.getParameter("phoneNum");
        
        Users user = new Users();
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setEmail(emailId);
        user.setPassword(password);
        user.setPhone(phoneNum);
        
        Validator v = new RegistrationValidator();
        v.addFormData("firstName", firstName);
        v.addFormData("lastName", lastName);
        v.addFormData("emailId", emailId);
        v.addFormData("password", password);
        v.addFormData("phoneNum", phoneNum);
        request.setAttribute("validator", v);
        
        //out.print(registrationBean.isEmailExists("cool.saurez@gmail.com"));
        
        if(!v.validateForm())
        {
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        }
        else
        {
            registrationBean.registerUser(user);
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "reg_success.jsp");
        }
        
        //out.print(v.getErrorMessage("firstName"));
        
        //request.setAttribute("user", user);
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
