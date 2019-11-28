<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/11/28
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>login</title>
  </head>
  <body>
  <form action="/LoginServlet" method="post">
    <table>
      <tr>
      <td>用户名</td>
        <td> <input type="text" name="user"></td>
      </tr>
      <tr>
        <td>密码</td>
      <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <td>验证码</td>
        <td> <input type="text" name="yzm"></td>
      </tr>
      <tr>
    <td colspan="2"><img src="/CheckCodeServlet" id="checkCode"/>
      <a id="change" href="javascript:void(0);" > 看不清换一张？</a></td>
      </tr>
      <tr>
      <td colspan="2"><button type="submit" value="提交">提交</button></td>
      </tr>
    </table>
  </form>
  <div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div>
  <div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error") %></div>

  <script>
    window.onload=function () {
      //加时间
      var img=document.getElementById("checkCode");
      img.onclick=function () {
        var date=new Date().getTime();
        img.src="/CheckCodeServlet?"+date; }
      var a=document.getElementById("change");
      a.onclick=function () {
        var date=new Date().getTime();
        img.src="/CheckCodeServlet?"+date; }

    }
  </script>
  </body>
</html>
