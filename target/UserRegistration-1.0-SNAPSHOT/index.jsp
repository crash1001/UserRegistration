

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login Credential Registration</title>
       
        <link href="main.css" rel="stylesheet" type="text/css">
        
    </head>
    <body>
        <h1>User Login Credential for RTS-WIFI Registration</h1>
        
        
        <form name="register" action="Verification/verify.jsp" method="POST" >
            <fieldset>
                <legend>Please Enter your details!</legend>
                <div>
                    <label for="name">Name:</label>
                    <input id="name" name="name" value="" pattern="[A-Za-z]+\s[A-Za-z]+" title="firstname lastname" aria-required="true" aria-describedby="name-format" type="text"
                           placeholder="What's your Name?">
                    <span id="name-format" class="help">Format: firstname lastname</span>
                </div>
                <div>
                    <label for="email">Email:</label>
                    <input id="email" name="email" value="" pattern="[A-Za-z._]+@[rts]+\.[com]+\.[n]+[p]" title="firstname.lastname@rts.com.np" aria-required="true" aria-describedby="email-format" type="text"
                           placeholder="Give me your RTS email?">
                    <span id="email-format"  class="help">Format: firstname.lastname@rts.com.np</span>
                    
                    <%-- <label for="email">Email:</label>
                    <input type="text" id="email" name="email" value="" aria-required="true" placeholder="Give me your RTS email?"
                           pattern="[a-z]+\.[a-z]+@[rts]+\.[com]+\.[np]$" title="firstname.lastname@rts.com.np" aria-describedby="email-format">
                    
                    <span id="email-format" class="help">Format: firstname.lastname@rts.com.np</span>--%>
                </div>
                <div>
                    <label for="userName">User ID:</label>
                    <input type="text" id="userID" name="userName" value="" required aria-required="true" placeholder="This will be your WIFI name be proud!">
                </div>
                <div>
                    <label for="password">Password:</label>
                    <input type="password" id="passwd1" name="pwd1" value="" required aria-required="true"
                           pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" placeholder="Enter Password"
                           onchange="form.pwd2.pattern = this.value;"
                           title="Enter a combination of atleast 6 characters, including UPPER/lowercase and numbers.!">
                </div>
                <div>
                    <label for="re-password">Re-type Password:</label>
                    <input type="password" id="passwd2" name="pwd2" value="" required aria-required="true"
                           pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" placeholder="Type Again>>>>Now we will know your password HAHAHAHA!"
                           title="Re-enter your Password">
                </div>
                <div class="button">
                      
                    <input type="submit" value="Register" name="submit" id="registerButton" /> 
                </div>
               
            </fieldset>
           
        </form>
    </body>
</html>

