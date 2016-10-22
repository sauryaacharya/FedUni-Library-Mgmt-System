<%@page import="utils.LoginValidator"%>
<%@page import="utils.Validator"%>
<jsp:include page="templates/header.jsp">
    <jsp:param name="title" value="Login At Federation University Community Library"/>
</jsp:include>
<%
    if(session.getAttribute("auth") != null)
    {
      response.sendRedirect("index.jsp");
    }
%>
<h2 style="font-family:Arial;color:#333333;text-shadow: 1px 1px 2px #ccc;">Member Login</h2>
<div style="border-top:1px solid #bbb;margin:9px 0px 9px 0px;"></div>
<div id="create_acc_panel">
    <h4 style="font-family:Arial;color:#333333;text-shadow: 0px 0px 1px #ccc;">Open Your New Account </h4>
    <br/>
    <div>
        <span style="font-family:Arial;font-size:14px;color:#4d4d4d;">Create an account with us and you'll be able to:</span>
    <ul>
        <li>Online Library Experience</li>
        <li>Loan Item</li>
        <li>Browse the library catalogue</li>
    </ul>
    </div>
    <br/>
    <input type="button" value="Click Here To Open A New Account >" id="create_acc_btn" onclick="location.href='./register.jsp';"/>
</div>
<div class="form_panel">
<form method="post" action="Login">
    <span style="font-family:Arial;font-size:15px;color:#404040;">Login at Federation Community Library.</span> <span style="color:#cc0000;font-family:Arial;font-size:15px;">* Required Field.</span><br/><br/>
    <label for="email_id"><span style="color:#216C2A;font-family:Arial;font-size:17px;">*</span>Email: </label><input type="text" id="email_id" name="userName" placeholder="Email" value="<%= (request.getParameter("userName") == null) ? "" : request.getParameter("userName") %>"/>
    <label for="password"><span style="color:#216C2A;font-family:Arial;font-size:17px;">*</span>Password: </label><input type="password" id="password" name="password" placeholder="Password" value="<%= (request.getParameter("password") == null) ? "" : request.getParameter("password") %>"/>
    <input type="hidden" id="redirectUrl" name="redirectUrl" value="<%= (request.getParameter("redirectUrl") == null) ? "" : request.getParameter("redirectUrl") %>"/>    
    <input type="submit" id="login_btn" name="login_btn" value="Login">
</form>
    
    <%
    Validator v = new LoginValidator();
    if(request.getParameter("login_btn") != null){
        v = (Validator)request.getAttribute("validator");
    %>
    <div style="font-family:Arial;color:#cc0000;font-size:13px;"><i class="fa fa-exclamation-triangle fa-2x" aria-hidden="true" style="vertical-align:middle;"></i> 
        <%= v.getErrorMessage("error") %>
    </div>
    <%
    }
    %>
<!--  

   -->
</div>
<div style="clear: both;"></div>
<%@include file="templates/footer.jsp" %>