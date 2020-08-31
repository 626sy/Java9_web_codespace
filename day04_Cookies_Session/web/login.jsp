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
    <script>
        window.onload = function () {
            document.querySelector("#img").onclick = function () {
                this.src = "/checkCodeServlet?time="+new Date().getTime();
            }
        }
    </script>
    <style>
        .error{
            color: red;
        }
        .box{
            border: solid 1px greenyellow;
            width: 400px;
            margin: auto;
        }
        span {
            display: inline-block;
            margin-right: 4px;
        }
        td {
            width: 100px;
        }
    </style>
</head>
<body>
<div class="box">

    <form action="/loginServlet" method="post">

<%--        <div>
            <span>用户名</span><input type="text" name="username">
        </div>
        <div>
            <span>密码</span><input type="password" name="password">
        </div>
        <div>
            <span>验证码</span><input type="password" name="checkCode">

        </div>
        <img src="/checkCodeServlet" alt="">
        <div>
            <input type="submit" value="登录">
        </div>--%>

    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="/checkCodeServlet" alt=""></td>
        </tr>
        <tr>
            <td ><input type="submit" value="登录"></td>
            <td><a href="register.jsp">注册</a></td>

        </tr>
    </table>
    </form>
</div>

<div class="error"><%=request.getAttribute("login_error") == null?"":request.getAttribute("login_error")%></div>
<div class="error"><%=request.getAttribute("cc_error") == null?"":request.getAttribute("cc_error")%></div>
</body>
</html>
