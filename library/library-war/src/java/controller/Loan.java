/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.AddBookBeanLocal;
import beans.LoanBeanLocal;
import entity.Users;
import entity.Books;
import entity.UserLoan;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Utility;
import org.json.simple.*;

/**
 *
 * @author saurya
 */
@WebServlet(name = "Loan", urlPatterns = {"/Loan"})
public class Loan extends HttpServlet {
    @EJB
    private AddBookBeanLocal addBookBean;
    
    @EJB
    private LoanBeanLocal loanBean;
    
    
    

    
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
        
        /*
        Date d = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.WEEK_OF_MONTH, 2);
        Date date = calendar.getTime();
        out.print(date);
        */
        
        //out.print(d);
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
       response.setContentType("application/json;charset=UTF-8");
       PrintWriter out = response.getWriter();
       if(request.getSession().getAttribute("auth") != null)
        {
            if(request.getParameter("book_id") != null && Utility.isInteger(request.getParameter("book_id"))){
                Integer book_id = Integer.parseInt(request.getParameter("book_id"));
                Integer user_id = (Integer)request.getSession().getAttribute("auth");
                Users u = new Users(user_id);
                Books b = new Books(book_id);
                Date currDate = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currDate);
                calendar.add(Calendar.WEEK_OF_MONTH, 2);
                Date dueDate = calendar.getTime();
                UserLoan loan = new UserLoan();
                loan.setBookId(b);
                loan.setUserId(u);
                loan.setDueDate(dueDate);
                JSONObject obj = new JSONObject();
                
                Books updateBook = addBookBean.getBookById(book_id);
                if(updateBook.getIsAvailable()){
                    loanBean.loanBook(loan);
                    updateBook.setIsAvailable(false);
                    addBookBean.updateBook(updateBook);
                    obj.put("status", "success");
                    
                }else{
                    obj.put("status", "failed");
                }
                
                out.print(obj.toJSONString());
            }
        }
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
