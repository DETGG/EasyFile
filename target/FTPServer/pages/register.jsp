<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>register</title>
    <script type="text/javascript" src="/static/js/reg_exp.js"></script>
    <script type="text/javascript" src="/static/js/jquery-3.5.1.min.js"></script>
    <script type="text/javascript">
        /**
         * check the register inf when submit
         * @returns {boolean}
         */
        function checkRegister() {
            const id = document.getElementById('id').value;
            const password = document.getElementById('password').value;
            const password2 = document.getElementById('password2').value;
            const username = document.getElementById('username').value;
            const email = document.getElementById('email').value;
            const code = document.getElementById('code').value;
            if(isANumber(id) && id >= 10000 && password.length >= 6 && password2.length >= 6 &&
                password === password2 && checkBlankForm(username) && testEmail(email) && checkBlankForm(code)){
                alert("SUCCESS")
                return true;
            }else {
                alert("ERROR INPUT");
                return false;
            }
        }
    </script>
    <link rel="stylesheet" href="/static/css/normal.css" type="text/css"/>
</head>
<body>
<div align="center">
    <form action="/userServlet" method="post" onsubmit="return checkRegister()">
        <input type="hidden" name="action" value="register">
        <table>
            <tr>
                <td> <label>id:</label></td>
                <td><label for="id"></label><input type="text" autocomplete="off" tabindex="1" name="id" id="id"><br/></td>
            </tr>
            <tr>
                <td><label>password:</label></td>
                <td><label for="password"></label><input type="text" autocomplete="off" tabindex="1" name="password" id="password"><br/></td>
            </tr>
            <tr>
                <td><label>confirm password:</label></td>
                <td><input type="text" autocomplete="off" tabindex="1" name="password2" id="password2"><br/></td>
            </tr>
            <tr>
                <td><label>username:</label></td>
                <td><input type="text" autocomplete="off" tabindex="1" name="username"  id="username"><br/></td>
            </tr>
            <tr>
                <td><label>email:</label></td>
                <td><input type="text" autocomplete="off" tabindex="1" name="email" id="email"><br/></td>
            </tr>
            <tr>
                <td><label>code</label></td>
                <td> <input type="text" autocomplete="off" tabindex="1" name="code" id="code"><br/></td>
            </tr>
            <tr>
                <td><input type="submit" value="register" id="register"></td>
                <td><a href="/index.jsp">back to login</a></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
