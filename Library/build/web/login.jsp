<%-- 
    Document   : login
    Created on : 13/06/2024, 12:22:14
    Author     : Sari Cohen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    </head>
    <style>
        body{
            background-color: aquamarine;
        }
        form{
            margin-left: 28vw;
            border: 3px solid black;
            font-size: 25px;
            padding: 80px;
            width: max-content;
            border-radius: 25px;
            background-color: rgba(255, 255, 255, 0.793);
        }
        h2{
            text-align: center;
            font-size: 50px;
        }
        #submit{
            background-color: rgb(108, 197, 167);
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            width: 30vw;
        }
        #submit:hover{
            background-color: rgb(108, 197, 167, 0.8);
        }
    </style>
    <body>
        <h2>Login</h2>
        <h1 style='color:red;text-align: center'>
            <%
                String error = null;
                session = request.getSession(true);
                if (session.getAttribute("error") != null) {
                    error = session.getAttribute("error").toString();
                    out.println(error);
                }
            %>
        </h1>
        <form action="LoginServlet" method="get">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" placeholder="enter your username"><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"  placeholder="enter your password"><br><br>
        <input id="submit" type="submit" value="Login">
    </form>    

</body>
</html>
