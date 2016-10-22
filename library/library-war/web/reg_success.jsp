<jsp:include page="templates/header.jsp">
    <jsp:param name="title" value="Register At Federation University Community Library"/>
</jsp:include>
<% 
String fullRefererUrl = request.getHeader("referer");

if(fullRefererUrl == null){
    response.sendRedirect("register.jsp");
} else{
    if(!(fullRefererUrl.contains("Register") || fullRefererUrl.contains("register.jsp")))
    {
    response.sendRedirect("register.jsp");
    }

}     
%>
<div style="text-align:center;font-family:Arial;font-size:14px;color:#595959;">
    <i class="fa fa-check-circle fa-5x" aria-hidden="true" style="color:#008000;"></i><br/>
    You are successfully registered with us. Click <a href="./login.jsp" style="text-decoration:underline;color:#1f7a7a;">here</a> to login to the website.
</div>
<%@include file="templates/footer.jsp" %>