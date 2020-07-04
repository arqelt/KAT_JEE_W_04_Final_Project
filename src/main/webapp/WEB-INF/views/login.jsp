
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
    <title>Login</title>
        <link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
</head>
<body>
<div id="loginContainer">
<form method="post">
    <div><label> Login : <input type="text" name="username"/> </label></div>
    <br>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</div>
</body>
</html>

