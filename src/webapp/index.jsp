<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html">
        <title>Project 1</title>
    </head>
    <body>
        <h2><center>Welcome! Please Login!</center></h2>
        <form method="get" action="LoginServlet">
            <center>
            <table>
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username"/></td>
                    </tr>
                    <tr></tr><tr></tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pw"/></td>
                    </tr>
                </tbody>
            </table>
            </br>
           	<input type="submit" value="Login"/>
            </br></br>
            <a href="CreateAccount.jsp">Create Account</a> 
            </center>
        </form>
    </body>
</html>