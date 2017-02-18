<%-- 
    Document   : newjspregisterController
    Created on : Feb 10, 2017, 8:31:04 AM
    Author     : ROOT
--%>

<%@page import="com.mycompany.userregistration.FileHandler"%>
<%@page import="com.mycompany.userregistration.SendMail"%>
<%@page import="java.util.Random" %>
<%@page import="java.io.IOException"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="theUser" class="com.mycompany.userregistration.User" scope="session" />
<jsp:setProperty  property="*" name="theUser"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Verification</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="main.css" rel="stylesheet" type="text/css">
        
    </head>
    <body>
        <% 
            
            FileHandler handler = new FileHandler();
            SendMail mail = new SendMail();
            mail.setCurrentUser(theUser);
            String userHash = "/tmp/user_info.txt";
           // String userHash = "E://hash.txt";
            //String saveLogPath = "E://log1.txt";
            //String saveLogPath = "/home/radius/user_wifi_credentials.txt";
            //handler.saveToLog(saveLogPath);
            Random random = new Random();
            String passCode = Integer.toString(random.nextInt(100000));
            handler.setCurrentUser(theUser);
            theUser.setVerifyCode(passCode);
            handler.userHash(userHash);
            mail.mail(passCode);
            
            
            
            
        %>
        <form name="Verify" action="verified.jsp" method="POST">
        <fieldset>
            <legend>A confirmation mail with Verification code has been sent to <%=theUser.getEmail()%></legend>
            <div>
                <p>Please Enter the Verification Code below to activate you RTS Wifi Login Credentials!</p>
            </div>
            <div>
                    Verification Code :
                    <input id="verifyCode" name="verifyCode" value="" aria-required="true" aria-describedby="name-format" type="text" 
                           pattern="^[0-9]*" required>
                    
                    <input type="submit" value="Submit" name="submit" id="submitButton" />
                    
                </div>

        </fieldset>
        </form>
    </body>
</html>
