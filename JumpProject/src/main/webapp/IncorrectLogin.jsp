<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html">
        <title>Project 1</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    </head>
    <body>
        <div class="alert alert-danger"><center>Incorrect Login</center></div>
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