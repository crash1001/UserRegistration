<%-- 
    Document   : verified.jsp
    Created on : Feb 12, 2017, 7:24:51 AM
    Author     : ROOT
--%>

<%@page import="com.mycompany.userregistration.SendMail"%>
<%@page import="com.mycompany.userregistration.FileHandler"%>
<%@page import="com.mycompany.userregistration.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            String path = "/tmp/user_info.txt";
            String log="/tmp/user_wifi_credentials.txt";
            User theUser = new User();
            String code = request.getParameter("verifyCode");
            FileHandler handler = new FileHandler();
           
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        
        
    </head>
    <body>
        <%
            theUser = handler.readUserHash(path, code);
            String checkCode = theUser.getVerifyCode();
            if(checkCode.equals(code))
            {
                SendMail mail = new SendMail();
                mail.setCurrentUser(theUser);
                handler.setCurrentUser(theUser);
                handler.saveToLog(log);
                mail.mail();
                out.println("You Have been registered your UserName and Password is sent to your email Address");
            }
            else
            {
                out.println("Incorrect Code, Please Check your verification code and try again");
            }
        %>
        <h1></h1>
    </body>
</html>
