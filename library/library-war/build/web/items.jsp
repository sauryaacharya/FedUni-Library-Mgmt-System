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
    LinkedHashMap<BooksCategory, List<Books>> books_list = (LinkedHashMap)request.getAttribute("all_books");
    Set <BooksCategory> keys = books_list.keySet();
%>

    <div id="book_list">
        <% for(BooksCategory k : keys)
        {
        %>
        <div class="cat_book" style="margin-bottom:15px;">
            <div style="background:#1f7a7a;padding:8px;">
            <a href="Books?cat_id=<%= k.getCategoryId() %>" class="cat_link"><h2 style="font-family:Arial;color:#fff;"><% out.print(k.getCategoryName()); %></h2></a>
            </div> 
            
            <%
            for(Books b : books_list.get(k)){
            %>
            <div class="book_thumb_row">
                <a href="Books?id=<%= b.getBookId() %>" class="tit_link"><h4 style="font-family:Arial;color:#0086b3;"><% out.print(b.getTitle()); %></h4></a>
                <span style="font-family:Arial;color:#333;font-size:12px;"><strong>Author: </strong><%= b.getAuthor() %></span><br/>
                <div style="margin-top:5px;font-family:Arial;font-size:13px;color:#666;text-align:justify;">
                <%= b.getDescription() %>
                </div><br/>
                <a href="Books?id=<%= b.getBookId() %>" class="view_more">View</a>
            </div>
            <%   
            }
            %>
        </div>
        <%
        }
        %>
       
    </div>
<%@include file="templates/footer.jsp" %>