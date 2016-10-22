<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${param.title}</title>
        <link rel="stylesheet" type="text/css" href="./css/style.css"/>
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css" type="text/css"/>
        <script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.min.js"></script>    
    </head>
    <body>
        <div id="main_body_wrapper">
            <div id="header">
                <div id="header_content">
                    <div id="header_right">
                        <div id="user_log">
                            <%
                               if(session.getAttribute("auth") != null)
                              { 
                            %>
                            <i class="fa fa-sign-in" aria-hidden="true"></i><a href="Logout"> Logout (<%= session.getAttribute("name").toString() %>)</a>
                            <% 
                              }
                               else{
                            %>
                            <i class="fa fa-sign-in" aria-hidden="true"></i><a href="login.jsp"> Login</a> | <i class="fa fa-user" aria-hidden="true"></i><a href="register.jsp"> Create An Account</a>
                            <% 
                               }
                            %>
                        </div>
                    </div>
                    <!--end header_right-->
                    <div id="header_left">
                    <div id="search_form">
                        <form method="get" action="Search">
                            <input type="text" id="search_text" name="search_text" placeholder="Search Item By Title, Author, ISBN" value="<%= (request.getParameter("search_text") == null) ? "" : request.getParameter("search_text") %>"/>
                            <button id="search_btn" name="search_btn"><i class="fa fa-search fa-1x" aria-hidden="true"></i></button>
                        </form>
                    </div>
                    <div id="logo">
                        <img src="./images/logo.png">
                    </div>
                        <div style="clear:both;"></div>
                    </div>
                    <div style="clear:both;"></div>
                    <!--end header_left-->
                </div>
                <!--end header_content-->
            </div>
            <!--end header-->
            <div id="navbar">
                <div id="navbar_content">
                    <ul>
                        <li><a href="Index">Home</a></li>
                        <li><a href="Items">Items</a></li>
                        <li><a href="#">Contact US</a></li>
                        <%
                          if(session.getAttribute("auth") != null && (Boolean)session.getAttribute("isAdmin") == false)
                          {
                        %>
                        <li><a href="Profile">My Profile</a></li>
                        <%
                          }
                        %>
                    </ul>
                </div>
                
            </div>
            <div id="main_page">
                <div id="main_page_content">
                    <div style="padding:20px 0px 20px 0px;">
