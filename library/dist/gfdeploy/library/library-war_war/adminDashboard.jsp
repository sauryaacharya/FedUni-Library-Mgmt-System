<%@page import="entity.Books"%>
<%@page import="java.util.List"%>
<% 
    response.sendRedirect("AdminDashboard");
%>
<jsp:include page="templates/admin/header.jsp">
    <jsp:param name="title" value="Login At Federation University Community Library"/>
</jsp:include>
<br/>
<h2 style="font-family:Arial;color:#555;">Books In The Library</h2>
    <%
    List<Books> book_list = (List)request.getAttribute("book_list");
    //out.println(book_list.get(0).getDescription());
    %>
    
    <table id="book_list_tbl">
        <tr>
            <th>Book Name</th>
            <th>Category</th>
            <th>Author</th>
            <th>Publisher</th>
            <th>Published Date</th>
            <th>ISBN</th>
            <th>Action</th>
        </tr>
        <%
        for(Books book : book_list){
        %>
        <tr>
            <td><%= book.getTitle() %></td>
            <td><%= book.getCategoryId().getCategoryName() %></td>
            <td><%= book.getAuthor() %></td>
            <td><%= book.getPublisher() %></td>
            <td><%= book.getPublishDate() %></td>
            <td><%= book.getIsbn() %></td>
            <td class="action"><i class="fa fa-pencil" aria-hidden="true"></i><a href="?action=edit&book_id=<%= book.getBookId() %>" style="color:#008000;"> Edit</a> | <i class="fa fa-trash" aria-hidden="true"></i><a href="?action=delete&book_id=<%= book.getBookId() %>" style="color:#cc0000;"> Delete</a></td>
        </tr>
        <%
        }
        %>
       
    </table>
<%@include file="templates/admin/footer.jsp" %>