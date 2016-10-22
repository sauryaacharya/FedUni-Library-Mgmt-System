<%@ page import="utils.Validator, utils.RegistrationValidator" %>
<%
    if(session.getAttribute("auth") != null)
                              { 
                                  response.sendRedirect("Index");
                              }
    Validator v = new RegistrationValidator();
    if(request.getParameter("register_btn") != null)
        {
            v = (Validator)request.getAttribute("validator");
        }
%>
<jsp:include page="templates/header.jsp">
    <jsp:param name="title" value="Register At Federation University Community Library"/>
</jsp:include>
<h2 style="font-family:Arial;color:#333333;text-shadow: 1px 1px 2px #ccc;">Register at Federation Community Library</h2>
<div style="border-top:1px solid #bbb;margin:9px 0px 9px 0px;"></div>
<div class="form_panel">
    <span style="font-family:Arial;font-size:15px;color:#404040;">Please fill up the form below to register at Federation Community Library.</span> <span style="color:#cc0000;font-family:Arial;font-size:15px;">* Required Field.</span><br/><br/>
    
    <form method="post" action="Register">
        <label for="first_name"><span style="color:#216C2A;font-family:Arial;font-size:17px;">*</span>Firstname: </label><span id="f_name_msg" style="font-family:Arial;font-size:13px;color:#cc0000;"><%= v.getErrorMessage("firstName") %></span><input type="text" id="first_name" name="firstName" placeholder="Firstname" value="<%= (request.getParameter("firstName") == null) ? "" : request.getParameter("firstName") %>"/>
    <label for="middle_name">Middlename: (Optional)</label><input type="text" id="middle_name" name="middleName" placeholder="Middlename" value="<%= (request.getParameter("middleName") == null) ? "" : request.getParameter("middleName") %>"/>
    <label for="last_name"><span style="color:#216C2A;font-family:Arial;font-size:17px;">*</span>Lastname: </label><span id="l_name_msg" style="font-family:Arial;font-size:13px;color:#cc0000;"><%= v.getErrorMessage("lastName") %></span><input type="text" id="last_name" name="lastName" placeholder="Lastname" value="<%= (request.getParameter("lastName") == null) ? "" : request.getParameter("lastName") %>"/>
    <label for="email_id"><span style="color:#216C2A;font-family:Arial;font-size:17px;">*</span>Email: </label><span id="email_msg" style="font-family:Arial;font-size:13px;color:#cc0000;"><%= v.getErrorMessage("emailId") %></span><input type="text" id="email_id" name="emailId" placeholder="Email" value="<%= (request.getParameter("emailId") == null) ? "" : request.getParameter("emailId") %>"/>
    <label for="password"><span style="color:#216C2A;font-family:Arial;font-size:17px;">*</span>Password: </label><span id="pass_msg" style="font-family:Arial;font-size:13px;color:#cc0000;"><%= v.getErrorMessage("password") %></span><input type="password" id="password" name="password" placeholder="Password At Leas 8 characters" value="<%= (request.getParameter("password") == null) ? "" : request.getParameter("password") %>"/>
    <label for="phone"><span style="color:#216C2A;font-family:Arial;font-size:17px;">*</span>Phone: </label><span id="phn_msg" style="font-family:Arial;font-size:13px;color:#cc0000;"><%= v.getErrorMessage("phoneNum") %></span><input type="text" id="phone" name="phoneNum" placeholder="10 Digit Phone Number" value="<%= (request.getParameter("phoneNum") == null) ? "" : request.getParameter("phoneNum") %>"/>
    <input type="submit" id="register_btn" name="register_btn" value="Register"/>
    </form>
    <%
        
        
                
    %>
</div>
<%@include file="templates/footer.jsp" %>