<%-- 
    Document   : Login
    Created on : 9-jan-2015, 20:12:31
    Author     : Ikke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(null == session.getAttribute("FirstLoad")){
        session.setAttribute("FirstLoad", "0");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style type="text/css" >            
            html{
                width: 100%;
                height: 100%;
                background-image: url("Images/teslaSpoel.jpg");
                background-repeat: no-repeat;
                background-size: 100% 100%;
            }
            .center{
                position: relative;
                float: top;
                width: 50%;
                left: 40%;
            }
            .label{
                color: red;
            }
            h1{
                color: aqua;
            }
        </style>
    </head>
    <body class="body">
        <div class="center">
        <h1>Login</h1>
        <form method="POST" action="LoginController" role="form">
            <label for="UserName" class="label">Username:</label>
            <input type="text" class="text" name="UserName" placeholder="UserName" 
                   value="<%
                       if("0".equals(session.getAttribute("FirstLoad"))){
                            %><%
                       }
                        else{
                            %>${sessionScope.UserName}<%
                       } %>"><br><br>
            <label for="PassWord" class="label">Paswoord:</label>
            <input type="text" class="text" name="PassWord" placeholder="PassWord"><br><br>
            <input type="submit" class="Login" value="Login">
        </form><br>
        <label name="Error" style="color: aqua; visibility: 
               <% if(null == session.getAttribute("Error") || "".equals(session.getAttribute("Error"))){%>
                hidden
               <%} else{%>
                visible
                <%}%>">"${sessionScope.Error}"
        </label>
         </div>       
    </body>
</html>
