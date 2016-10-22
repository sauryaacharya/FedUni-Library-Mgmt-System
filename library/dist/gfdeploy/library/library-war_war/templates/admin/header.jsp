<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${param.title}</title>
        <link rel="stylesheet" type="text/css" href="./css/style.css"/>
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css" type="text/css"/>
        <style type="text/css">
            #ad_action a
            {
               font-family:Arial;
               font-size:13px;
               color:#666;
               text-decoration:none;
               background:#fafafa;
               border:1px solid #ccc;
               padding:10px;
               border-radius:4px;
            }
            
            #ad_action a:hover
            {
                background:#fdfdfd;
                box-shadow:0px 0px 2px #ccc;
            }
        </style>
    </head>
    <body>
        <div id="main_body_wrapper">
            <div id="header" style="background:#fafafa;">
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
                            %>
                        </div>
                    </div>
                    <!--end header_right-->
                    <div id="header_left">
                    <div style="float:right;width:415px;margin-top:17px;">
                        <h1 style="font-family:Arial;color:#666;"> Admin Panel</h1>
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
            <div style="border-top:3px solid #1f7a7a;"></div>
            <div id="main_page">
                <div id="main_page_content">
                    <div style="padding:20px 0px 20px 0px;">
                        <div id="ad_action">
                            <a href="AdminDashboard"><i class="fa fa-tachometer" aria-hidden="true"></i> Dashboard</a>
                            <a href="?action=add"><i class="fa fa-plus" aria-hidden="true"></i> Add A New Book</a>
                        </div>
                        <br/><hr/>