<%-- 
    Document   : welcome
    Created on : 13/06/2024, 12:20:54
    Author     : The user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WELCOME</title>
    </head>
    <body>
        <h2>Welcome to you 
             <%
            String name = null;
            session = request.getSession(true);
            if (session.getAttribute("username") != null) {
                name = session.getAttribute("username").toString();
            }
            out.println(name);
            %>  !
        </h2>
        <h3>The system recognized you and entered the site!! </h3>
        <%@include  file="./LoansManagement.html" %>
    </body>
</html>
