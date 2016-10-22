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
    Books b = (Books)request.getAttribute("bookById");
%>
<script type="text/javascript" src="js/script.js">
</script>
<div id="book_content">
    <input type="hidden" id="book_id" name="book_id" value="<%= b.getBookId() %>"/>
    <h2 style="font-family:Arial;color:#555;"><%= b.getTitle() %></h2><br/>
    <span style="font-family:Arial;color:#555;font-size:14px;font-weight:bold;">Availability:</span>
    
    <%
    if(b.getIsAvailable()){
        out.print("<span style='color:#008000;font-family:Arial;font-size:12px;'>Available</span>");
    }
    else{
        out.print("<span style='color:#cc0000;font-family:Arial;font-size:12px;'>Not available</span>");
    }
    %>
    
    <br/><br/>
    <%
    if(session.getAttribute("auth") != null && (Boolean)session.getAttribute("isAdmin") == false)
    {
    %>
    <button type="button" id="loan_book_btn" name="loan_book_btn" <% if(!b.getIsAvailable()){out.print("disabled style='opacity:0.5;'");}%>>Loan Book</button>
    &nbsp;&nbsp;
    <button type="button" id="bookmark_btn" name="bookmark_btn">Add To Bookmark</button>
    <br/><br/>
    <%
    }
    %>
    <div style="font-family:Arial;color:#555;font-size:14px;font-weight:bold;">Book Description</div>
    <div style="text-align:justify;font-family:Arial;font-size:13px;color:#666;margin-top:8px;">
    <%= b.getDescription() %>
    </div>
    <br/>
    <div style="font-family:Arial;color:#555;font-size:14px;font-weight:bold;">Book Details</div>
    <table id="book_details" border="0">
        <tr><td><strong>Publisher : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></td><td><%= b.getPublisher() %></td></tr>
        <tr><td><strong>Author : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></td><td><%= b.getAuthor() %></td></tr>
        <tr><td><strong>Year : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></td><td><%= b.getPublishDate() %></td></tr>
        <tr><td><strong>ISBN : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></td><td><%= b.getIsbn() %></td></tr>
    
    </table>
    <br/><br/>    
    <div style="font-family:Arial;color:#555;font-size:14px;font-weight:bold;">User Comments: <span id="num_cmnt"></span></div>
    <div id="users_comment" style="margin-top:5px;">
    </div>
    <br/>
    <% 
    if(session.getAttribute("auth") != null)
    {
    %>
    <h4 style="font-family:Arial;color:#555;">Post Your Comment</h4>
    <hr/>
    <textarea id="comment_text" name="comment_text" placeholder="Comments"></textarea>
    <button id="comment_post_btn" name="comment_post_btn">Post Comment</button>
    <%
    }
    %>
</div>
<%@include file="templates/footer.jsp" %>