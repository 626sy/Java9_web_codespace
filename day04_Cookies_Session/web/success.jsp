<%--
  Created by IntelliJ IDEA.
  User: 22864
  Date: 2020/8/29
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        tr{
            background-color: pink;
            /*font-size: 3em;*/
            /*display: inline-block;*/
            width: 20em;
            height: 4em;
            /*padding: 2px 5px;*/
        }
        td{
            display: inline-block;
            width: 9em;
            height: 4em;

        }
    </style>
</head>
<body>
<%--    <%--%>
<%--        String value = (String) request.getSession().getAttribute("user");--%>
<%--        response.getWriter().write(value);--%>
<%--    %>--%>
<h1><%=request.getSession().getAttribute("user")%>,欢迎您登录</h1>
<div>
    <table>
        <tr>
            <td>姓名</td>
            <td> <%=request.getSession().getAttribute("user")%></td>
        </tr>
        <tr>
            <td>密码</td>
            <td> <%=request.getSession().getAttribute("password")%></td>
        </tr>
    </table>
    <img src="img/a.jpg" alt="">

</div>

</body>
</html>
