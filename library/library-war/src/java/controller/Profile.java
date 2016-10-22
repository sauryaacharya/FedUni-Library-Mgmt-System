/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.ProfileBeanLocal;
import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author saurya
 */
@WebServlet(name = "Profile", urlPatterns = {"/Profile"})
public class Profile extends HttpServlet {
    @EJB
    private ProfileBeanLocal profileBean;
    
    

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
        PrintWriter out = response.getWriter();
        Integer user_id = (Integer)request.getSession().getAttribute("auth");
        if(request.getParameter("tab") == null)
        {
        request.setAttribute("userDetail", profileBean.getUserDetails(user_id));
        }
        
        if(request.getParameter("tab") != null && request.getParameter("tab").equals("bookmark"))
        {
            Users user = new Users(user_id);
            request.setAttribute("bookMark", profileBean.getUserBookmark(user));
        }
        
        if(request.getParameter("tab") != null && request.getParameter("tab").equals("loan"))
        {
            Users user = new Users(user_id);
            request.setAttribute("userLoan", profileBean.getUserLoan(user));
        }
        
        if(request.getParameter("tab") != null && request.getParameter("tab").equals("comment"))
        {
            Users user = new Users(user_id);
            request.setAttribute("userCmnt", profileBean.getUserComment(user));
        }
        
        RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
        view.include(request, response);
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
        processRequest(request, response);
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
