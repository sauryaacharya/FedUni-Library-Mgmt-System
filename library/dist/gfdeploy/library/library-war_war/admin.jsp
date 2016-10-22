<%@page import="utils.AdminLoginValidator"%>
<%@page import="utils.Validator"%>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Admin Login - Federation Community Library
        </title>
        <style type="text/css">
            body
            {
                
            }
            
            
            h1, h2, h3, h4
{
    margin:0;
    padding:0;
}
hr {
    height:1px;
    border:none;
    color:#cccccc;
    background:#cccccc;
    display:block;
}
            #ad_login_panel
{
    width:400px;
    margin:0 auto;
    padding:25px;
    background:#f8f8f8;
    border:1px solid #ddd;
    border-radius:3px;
    
}

#ad_login_panel label
{
    font-family:Arial;
    font-size:15px;
    color:#595959;
    font-weight:bold;
}

#ad_login_panel input, select
{
    margin:0px 0px 20px 0px;
}

#ad_login_panel form
{
    width:100%;
}

#username, #password
{
    width:100%;
    height:42px;
    border:2px solid #B8B8B8;
    font-family:Arial;
    font-size:17px;
    color:#5F5F5F;
    padding-left:5px;
    transition:all 0.3s ease-in-out;
    -moz-transition:all 0.3s ease-in-out;
    -webkit-transition:all 0.3s ease-in-out;
    -ms-transition:all 0.3s ease-in-out;
    -o-transition:all 0.3s ease-in-out;
}

#username:hover, #password:hover
{
    border:2px solid #1f7a7a;
}

#username:focus, #password:focus
{
    border:2px solid #1f7a7a;
    box-shadow:0px 0px 4px #1f7a7a;
}

#ad_login_btn
{
    background:#1f7a7a;
    border:none;
    color:#ffffff;
    font-family:Arial;
    font-size:16px;
    width:160px;
    height:37px;
    cursor:pointer;
    border-radius:2px;
    transition:all 0.3s ease-in-out;
-moz-transition:all 0.3s ease-in-out;
-webkit-transition:all 0.3s ease-in-out;
-ms-transition:all 0.3s ease-in-out;
-o-transition:all 0.3s ease-in-out;
}

#ad_login_btn:hover
{
    background:#1a6565;
}
        </style>
    </head>
    <body>
            <br/><br/>
            <div style="width:400px;margin:0 auto;text-align:center;padding:0px 20px 0px 20px;">
                <img src="images/logo.png" style="text-align:center;" width="140" height="60"/>
            </div>
            <div id="ad_login_panel">
                
    <h3 style="font-family:Arial;color:#333333;text-shadow: 1px 1px 2px #ccc;">Admin Login</h3>
<hr/>
    <form method="post" action="AdminLogin">
        <span style="font-family:Arial;font-size:15px;color:#404040;">Login at Federation Community Library Admin Panel. </span> <span style="color:#cc0000;font-family:Arial;font-size:15px;">* Required Field.</span><br/><br/>
    
        <label for="username"><span style="color:#cc0000;font-family:Arial;font-size:17px;">*</span>Username: </label><input type="text" id="username" name="userName" placeholder="Username" value=""/>
        <label for="password"><span style="color:#cc0000;font-family:Arial;font-size:17px;">*</span>Password: </label><input type="password" id="password" name="password" placeholder="Password" value=""/>
        <input type="submit" id="ad_login_btn" name="ad_login_btn" value="Login"/>
    </form>

<%
    Validator v = new AdminLoginValidator();
    if(request.getParameter("ad_login_btn") != null){
        v = (Validator)request.getAttribute("validator");
    %>
    <div style="font-family:Arial;color:#cc0000;font-size:13px;"><i class="fa fa-exclamation-triangle fa-2x" aria-hidden="true" style="vertical-align:middle;"></i> 
        <%= v.getErrorMessage("error") %>
    </div>
    <%
    }
    %>
            </div>
    </body>
</html>