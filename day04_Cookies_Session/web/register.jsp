<%--
  Created by IntelliJ IDEA.
  User: 22864
  Date: 2020/8/30
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="/login.jsp" method="post ">
            <table>
                <tr>
                    <td>用户名</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="password" value="password"></td>
                </tr>
                <tr>
                    <td>确认密码</td>
                    <td><input type="password" value="password"></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="注册">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
