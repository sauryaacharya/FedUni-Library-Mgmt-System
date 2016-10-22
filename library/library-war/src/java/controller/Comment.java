/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.CommentBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Books;
import entity.Users;
import entity.UsersComment;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.*;
import utils.Utility;
/**
 *
 * @author saurya
 */
@WebServlet(name = "Comment", urlPatterns = {"/Comment"})
public class Comment extends HttpServlet {
    @EJB
    private CommentBeanLocal commentBean;
    
    //JSONArray 
    
    

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
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(request.getParameter("book_id") != null && Utility.isInteger(request.getParameter("book_id")))
        {
        Books b = new Books(Integer.parseInt(request.getParameter("book_id")));
        List<UsersComment> list = commentBean.getCommentByBookId(b);
        JSONObject main_obj = new JSONObject();
        if(list != null)
        {
        JSONObject child_obj;
        JSONArray arr_list = new JSONArray();
        for(UsersComment c : list)
        {
            //JSONObject obj = new JSONObject();
            child_obj = new JSONObject();
            child_obj.put("comment_id", c.getCommentId());
            child_obj.put("user", c.getUserId().getFirstName() + " " + c.getUserId().getMiddleName() + " " + c.getUserId().getLastName());
            child_obj.put("comment", c.getComment());
            child_obj.put("time", c.getTime().toString());
            arr_list.add(child_obj);
        }
        
        
        main_obj.put("comments", arr_list);
        out.print(main_obj.toJSONString());
        out.close();
        }
        }
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
        response.setContentType("application/json;charset=UTF-8");
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
            String comment_text = request.getParameter("comment_text");
            Users u = new Users(user_id);
            Books b = new Books(book_id);
            UsersComment u_comment = new UsersComment();
            u_comment.setBookId(b);
            u_comment.setComment(comment_text);
            u_comment.setUserId(u);
            u_comment.setTime(new Date());
            commentBean.postComment(u_comment);
            JSONObject obj = new JSONObject();
            obj.put("status", "success");
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
