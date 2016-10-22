<%@page import="entity.UsersComment"%>
<%@page import="entity.UserLoan"%>
<%@page import="entity.UserBookmark"%>
<%@page import="entity.Users"%>
<%@page import="entity.BooksCategory"%>
<%@page import="java.util.Set"%>
<%@page import="entity.Books"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="utils.LoginValidator"%>
<%@page import="utils.Validator"%>
<jsp:include page="templates/header.jsp">
    <jsp:param name="title" value="Welcome to Federation Community Library | Home"/>
</jsp:include>
<%
    
%>
<div id="menu_content">
    <% 
    if(request.getParameter("tab") == null)
    {
       Users u = (Users)request.getAttribute("userDetail");
    %>
   <h2 style="font-family:Arial;color:#555;">My Profile</h2>
   <hr/>
   <table id="user_prof_det">
       <tr><td><strong>Name:</strong> </td><td><%= u.getFirstName() + " " + u.getMiddleName() + " " + u.getLastName() %></td></tr>
       <tr><td><strong>Email:</strong> </td><td><%= u.getEmail() %></td></tr>
       <tr><td><strong>Phone:</strong> </td><td><%= u.getPhone() %></td></tr>
   </table>
       <%
    }
       %>
       
    <%
    if(request.getParameter("tab") != null && request.getParameter("tab").equals("bookmark"))
        {
            List<UserBookmark> bookMarkList = (List)request.getAttribute("bookMark");
    %>
    <h2 style="font-family:Arial;color:#555;">My BookMarks</h2>
    <hr/>
    <%
       if(bookMarkList.size() != 0)
       {
    %>
    <table id="bookmark_tbl">
        <%
          for(UserBookmark bm : bookMarkList){  
        %>
        <tr><td><a href="Books?id=<%= bm.getBookId().getBookId() %>"><%= bm.getBookId().getTitle() %></a></td></tr>
        <%
          }
        %>
    </table>
    
    <%
       }
       else
       {
           out.print("<span style=\"font-family:Arial;color:#555;font-size:13px;\">No Bookmark Yet.</span>");
       }
        }
    %>
    
    <%
    if(request.getParameter("tab") != null && request.getParameter("tab").equals("loan"))
        {
            List<UserLoan> loanList = (List)request.getAttribute("userLoan");
    %>
    <h2 style="font-family:Arial;color:#555;">My Loan</h2>
    <hr/>
    <%
      if(loanList.size() != 0)
      {
    %>
    <table id="bookmark_tbl">
        <tr>
            <th>Book</th>
            <th>Return Date</th>
        </tr>
        <%
          for(UserLoan loan : loanList){  
        %>
        <tr>
            <td><%= loan.getBookId().getTitle() %></td>
            <td><%= loan.getDueDate() %></td>
        </tr>
        <%
          }
        %>
    </table>
    <%
      }
      else
      {
          out.print("<span style=\"font-family:Arial;color:#555;font-size:13px;\">No Loan Yet.</span>");
      }
        }
    %>
    
    <%
    if(request.getParameter("tab") != null && request.getParameter("tab").equals("comment"))
        {
            List<UsersComment> cmntList = (List)request.getAttribute("userCmnt");
    %>
    <h2 style="font-family:Arial;color:#555;">Comments</h2>
    <hr/>
       
        <%
          if(cmntList.size() != 0)
          {
          for(UsersComment cmnt : cmntList){  
        %>
        <div class="cmnt_list">
            <strong>Book:</strong> <%= cmnt.getBookId().getTitle() %><br/>
            <strong>Date:</strong> <%= cmnt.getTime() %><br/>
            <strong>Comment:</strong> <%= cmnt.getComment() %>
        </div>
        <%
          }
          }
          else
          {
              out.print("<span style=\"font-family:Arial;color:#555;font-size:13px;\">No Comment Yet.</span>");
          }
        %>
    
    <%
        }
    %>
</div>
<div id="profile_menu">
    <div style="background:#1f7a7a;;padding:7px 10px 7px 10px;">
    <h2 style="font-family:Arial;color:#fff;">Account Menu</h2>
    </div>
    <div id="exp_menu">
        <ul>
            <li><a href="?tab=bookmark">My Bookmarks</a></li>
            <li><a href="?tab=loan">My Loan</a></li>
            <li><a href="?tab=comment">Comments</a></li>
        </ul>
    </div>
</div>
<div style="clear:both;"></div>
<%@include file="templates/footer.jsp" %>