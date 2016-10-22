<%@page import="java.util.List"%>
<%@page import="entity.Books"%>
<%@page import="utils.LoginValidator"%>
<%@page import="utils.Validator"%>
<jsp:include page="templates/header.jsp">
    <jsp:param name="title" value="Login At Federation University Community Library"/>
</jsp:include>
<%
    List<Books> searchResult = (List)request.getAttribute("searchResult");
%>
<h2 style="font-family:Arial;color:#333333;text-shadow: 1px 1px 2px #ccc;">Search Results</h2>
<div style="border-top:1px solid #bbb;margin:9px 0px 9px 0px;"></div>
<%
    if(searchResult.size() != 0)
    {
    for(Books b : searchResult)
    {
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
    }
    else
    {
        out.print("<span style=\"font-family:Arial;color:#555;font-size:13px;\">Your search query doesnot match any book.</span>");
    }
%>
<%@include file="templates/footer.jsp" %>