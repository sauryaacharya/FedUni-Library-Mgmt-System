<%@page import="utils.AddBookValidator"%>
<%@page import="utils.Validator"%>
<%@page import="entity.BooksCategory"%>
<%@page import="java.util.List"%>
<%
    Validator v = new AddBookValidator();
    if(request.getParameter("add_book_btn") != null)
        {
            v = (Validator)request.getAttribute("validator");
        }
%>
<jsp:include page="templates/admin/header.jsp">
    <jsp:param name="title" value="Login At Federation University Community Library"/>
</jsp:include>
<br/>
<h2 style="font-family:Arial;color:#555;">Add A New Book</h2>
<div style="border-top:1px solid #bbb;margin:9px 0px 9px 0px;"></div>
<div class="form_panel">
    <span style="font-family:Arial;font-size:15px;color:#404040;">Please fill up the required field to add a new book.</span> <span style="color:#cc0000;font-family:Arial;font-size:15px;">* Required Field.</span><br/><br/>
    
     <%= (request.getAttribute("success_msg") == null) ? "" : request.getAttribute("success_msg") %>
    
    <form method="post" action="">
        <label for="book_name"><span style="color:#216C2A;font-family:Arial;font-size:17px;">*</span>Name: </label><span id="name_msg" style="font-family:Arial;font-size:13px;color:#cc0000;"><%= v.getErrorMessage("bookName") %></span><input type="text" id="book_name" name="bookName" placeholder="Book Name" value="<%= (request.getParameter("bookName") == null) ? "" : request.getParameter("bookName") %>"/>
    <label for="author"><span style="color:#216C2A;font-family:Arial;font-size:17px;">*</span>Author: </label><span id="author_msg" style="font-family:Arial;font-size:13px;color:#cc0000;"><%= v.getErrorMessage("author") %></span><input type="text" id="author" name="author" placeholder="Author Name" value="<%= (request.getParameter("author") == null) ? "" : request.getParameter("author") %>"/>
    <label for="publisher"><span style="color:#216C2A;font-family:Arial;font-size:17px;">*</span>Publisher: </label><span id="publisher_msg" style="font-family:Arial;font-size:13px;color:#cc0000;"><%= v.getErrorMessage("publisher") %></span><input type="text" id="publisher" name="publisher" placeholder="Publisher" value="<%= (request.getParameter("publisher") == null) ? "" : request.getParameter("publisher") %>"/>
    <label for="publish_date"><span style="color:#216C2A;font-family:Arial;font-size:17px;">*</span>Published Date: </label><span id="date_msg" style="font-family:Arial;font-size:13px;color:#cc0000;"><%= v.getErrorMessage("publishDate") %></span><input type="text" id="publish_date" name="publishDate" placeholder="Published Date" value="<%= (request.getParameter("publishDate") == null) ? "" : request.getParameter("publishDate") %>"/>
    <label for="isbn"><span style="color:#216C2A;font-family:Arial;font-size:17px;">*</span>ISBN: </label><span id="isbn_msg" style="font-family:Arial;font-size:13px;color:#cc0000;"><%= v.getErrorMessage("isbn") %></span><input type="text" id="isbn" name="isbn" placeholder="ISBN" value="<%= (request.getParameter("isbn") == null) ? "" : request.getParameter("isbn") %>"/>
    <label for="book_cat"><span style="color:#216C2A;font-family:Arial;font-size:17px;">*</span>Category: </label><span id="book_cat_msg" style="font-family:Arial;font-size:13px;color:#cc0000;"><%= v.getErrorMessage("category") %></span>
    <select id="book_cat" name="book_cat">
        <%
        List<BooksCategory> cat_list = (List)request.getAttribute("book_category");
        for(BooksCategory cat : cat_list){
        %>
        <option value="<%= cat.getCategoryId()%>"<% if(request.getParameter("book_cat") != null && request.getParameter("book_cat").equals(String.valueOf(cat.getCategoryId()))){out.print(" selected");}else{out.print("");}%>><%= cat.getCategoryName() %></option>
        <%
        }
        %>
    </select>
    <label for="description"><span style="color:#216C2A;font-family:Arial;font-size:17px;">*</span>Description: </label><span id="desc_msg" style="font-family:Arial;font-size:13px;color:#cc0000;"><%= v.getErrorMessage("description") %></span>
    <textarea id="description" name="description" placeholder="Description"><%= (request.getParameter("description") == null) ? "" : request.getParameter("description") %></textarea>
    <input type="submit" id="add_book_btn" name="add_book_btn" value="Add Book"/>
    </form>
</div>
<%@include file="templates/admin/footer.jsp" %>