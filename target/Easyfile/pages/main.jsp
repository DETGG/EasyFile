<%@ page import="com.wzx.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.File" %>
<%@ page import="com.wzx.pojo.FileName" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: 15815
  Date: 2020/7/20
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%
    List<FileName> list = (List<FileName>)session.getAttribute("files");
    int fileNum = list.size();
    String tmp = "";
    for(int i=0;i<fileNum;i++){
        tmp +="<tr>"
                +"<td>"+list.get(i).getFilename()+"</td>"
                + "<td><a href=\"/downloadServlet?download="+ list.get(i).getFilename()+"\">download</a></td>"
                +"<td><a href=\"/deleteServlet?delete="+list.get(i).getFilename()+"\">delete</a></td>"
                + "</tr>";
    }
%>
<html>
<head>
    <title>${sessionScope.user.username}</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/reg_exp.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/normal.css" type="text/css"/>
</head>
    <body>
    <h1 align="center">Welcome to the HttpFileServer</h1>
    <div align="center">
        <form action="${pageContext.request.contextPath}/uploadServlet" method="post"
              enctype="multipart/form-data">
            <table>
                <tr>
                    <td><input type="file" name="file"></td>
                    <td><input type="submit" value="upload"></td>
                </tr>
            </table>
        </form>
        <table>
            <%=tmp%>
        </table>
    </div>
    </body>
</html>