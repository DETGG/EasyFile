<html>
<head>
    <script type="text/javascript" src="../static/js/reg_exp.js"></script>
    <script type="text/javascript">
        function checkLogin() {
            const id = document.getElementById('id').value;
            const password = document.getElementById('password').value;
            if (id!==""&&isANumber(id)&& password.length>=1) {
                return true;
            } else {
                alert("ERROR ID OR PASSWORD");
                return false
            }
        }
    </script>
    <link rel="stylesheet" href="static/css/normal.css" type="text/css"/>
</head>
<body>
<h1 align="center">HttpFileServer</h1>
<div align="center">
<form action="/userServlet" method="post"
      onsubmit="return checkLogin()">
    <input type="hidden" name="action" value="login">
    <table>
        <tr>
            <td><label>id:</label></td>
            <td><label><input type="text" autocomplete="on" tabindex="1" name="id" id="id" value="10000"></label><br/></td>
        </tr>
        <tr>
            <td><label>password:</label></td>
            <td><label for="password"></label><input type="password" autocomplete="off" tabindex="1" name="password" id="password"><br/></td>
        </tr>
        <tr>
            <td><input type="submit" value="login" id="login"><br/></td>
            <td><a href="pages/register.jsp">click to register</a></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
        </tr>
    </table>
</form>
</div>
<%--<a href="pages/upload.jsp">click to upload</a><br/>--%>
<%--<a href="downLoadServlet">click to download</a><br/>--%>
<%--<a href="cookieServlet">click to tryCookie</a><br/>--%>
<%--<a href="sessionServlet">click to trySession</a><br/>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>--%>
<%--<script src="http://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js">--%>
</body>
</html>
