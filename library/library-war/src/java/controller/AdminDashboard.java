/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.AddBookBeanLocal;
import beans.AdminDashboardBeanLocal;
import entity.Books;
import entity.BooksCategory;
import entity.BooksFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.AddBookValidator;
import utils.Utility;
import utils.Validator;
import java.util.Collections;
/**
 *
 * @author saurya
 */
@WebServlet(name = "AdminDashboard", urlPatterns = {"/AdminDashboard"})
public class AdminDashboard extends HttpServlet {
    @EJB
    private AddBookBeanLocal addBookBean;
    
    @EJB
    private AdminDashboardBeanLocal adminDashboardBean;
    
    
    

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
        if(request.getSession().getAttribute("auth") == null){
                response.sendRedirect("admin.jsp");
                return;
        }
        
        if(request.getSession().getAttribute("isAdmin") != null && (Boolean)request.getSession().getAttribute("isAdmin") == false){
                response.sendRedirect("admin.jsp");
                return;
            }
        
        if(request.getParameter("action") != null && request.getParameter("action").equals("add"))
        {
            request.setAttribute("book_category", addBookBean.getBookCategory());
            RequestDispatcher view = request.getRequestDispatcher("addBook.jsp");
            view.include(request, response);
            return;
        }
        
        if(request.getParameter("action") != null && request.getParameter("action").equals("edit") && request.getParameter("book_id") != null && Utility.isInteger(request.getParameter("book_id"))){
            request.setAttribute("book_category", addBookBean.getBookCategory());
            request.setAttribute("book", addBookBean.getBookById(Integer.parseInt(request.getParameter("book_id"))));
            RequestDispatcher view = request.getRequestDispatcher("editBook.jsp");
            view.include(request, response);
            return;
        }
        
        if(request.getParameter("action") != null && request.getParameter("action").equals("delete") && request.getParameter("book_id") != null && Utility.isInteger(request.getParameter("book_id"))){
            Books book = addBookBean.getBookById(Integer.parseInt(request.getParameter("book_id")));
            addBookBean.deleteBook(book);
            response.sendRedirect("AdminDashboard");
            return;
        }
        //request.setAttribute("book_category", addBookBean.getBookCategory());
        request.setAttribute("book_list", adminDashboardBean.getAllBook());
        RequestDispatcher rd = request.getRequestDispatcher("adminDashboard.jsp");
        rd.include(request, response);
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
        if(request.getParameter("add_book_btn") != null)
        {
            String bookName = request.getParameter("bookName");
            String author = request.getParameter("author");
            String publisher = request.getParameter("publisher");
            String publishDate = request.getParameter("publishDate");
            String isbn = request.getParameter("isbn");
            String description = request.getParameter("description");
            String cat_id = request.getParameter("book_cat");
            
            BooksCategory cat = new BooksCategory();
            cat.setCategoryId(Integer.parseInt(cat_id));
            
            Books book = new Books();
            book.setTitle(bookName);
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.setPublishDate(publishDate);
            book.setIsbn(isbn);
            book.setDescription(description);
            book.setCategoryId(cat);
            book.setIsAvailable(true);
            
            Validator v = new AddBookValidator();
            v.addFormData("bookName", bookName);
            v.addFormData("author", author);
            v.addFormData("publisher", publisher);
            v.addFormData("publishDate", publishDate);
            v.addFormData("isbn", isbn);
            v.addFormData("description", description);
            v.addFormData("category", cat_id);
            
            request.setAttribute("validator", v);
            request.setAttribute("success_msg", "");
            if(v.validateForm())
            {
                request.setAttribute("success_msg", "<div style=\"font-family:Arial;color:#216C2A;font-size:13px;background:#f5f5f5;border:1px solid #ccc;padding:8px;margin-bottom:8px;\">Book has been successfully added.</div>");
                addBookBean.addBook(book);
                processRequest(request, response);
            }
            else
            {
               processRequest(request, response);
            }
            
        }
        
        if(request.getParameter("save_book_btn") != null){
            
            String bookName = request.getParameter("bookName");
            String author = request.getParameter("author");
            String publisher = request.getParameter("publisher");
            String publishDate = request.getParameter("publishDate");
            String isbn = request.getParameter("isbn");
            String description = request.getParameter("description");
            String cat_id = request.getParameter("book_cat");
            
            BooksCategory cat = new BooksCategory();
            cat.setCategoryId(Integer.parseInt(cat_id));
            
            Books book = addBookBean.getBookById(Integer.parseInt(request.getParameter("book_id")));
            book.setTitle(bookName);
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.setPublishDate(publishDate);
            book.setIsbn(isbn);
            book.setDescription(description);
            book.setCategoryId(cat);
            
            Validator v = new AddBookValidator();
            v.addFormData("bookName", bookName);
            v.addFormData("author", author);
            v.addFormData("publisher", publisher);
            v.addFormData("publishDate", publishDate);
            v.addFormData("isbn", isbn);
            v.addFormData("description", description);
            v.addFormData("category", cat_id);
            
            request.setAttribute("validator", v);
            request.setAttribute("success_msg", "");
            
            if(v.validateForm())
            {
                request.setAttribute("success_msg", "<div style=\"font-family:Arial;color:#216C2A;font-size:13px;background:#f5f5f5;border:1px solid #ccc;padding:8px;margin-bottom:8px;\">Book has been successfully updated.</div>");
                addBookBean.updateBook(book);
                processRequest(request, response);
            }
            else
            {
               processRequest(request, response);
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
