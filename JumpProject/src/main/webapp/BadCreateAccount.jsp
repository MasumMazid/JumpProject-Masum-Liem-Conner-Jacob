<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html">
        <title>Project 1</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    </head>
    <body>
    	<div class="alert alert-danger"><center>Username already exists!</center></div>
    	<h2><center>Welcome to TV Show Tracker!</center></h2>
        <h4><center>Please fill in the form below!</center></h4>
        <form method="get" action="CreateAccount">
            <center>
            <table>
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pw"/></td>
                    </tr>
                    <tr>
                        <td>Verify Password</td>
                        <td><input type="password" name="pw-verification"/></td>
                    </tr>
                    <tr>
                        <td>Full Name</td>
                        <td><input type="text" name="full-name"/></td>
                    </tr>
                </tbody>
            </table>
            </br>
            <input type="submit" value="Create Account"/>
            </center>
        </form>
    </body>
</html>