<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- 第一种访问方式 -->
<a href="account/findAccount">查询账户1</a>

<!-- 第二种访问方式 -->
<a href="${pageContext.request.contextPath}/account/findAccount">查询账户2</a>

<hr/>

<a href="account/saveAccount">保存账户，get 请求</a>

<br/>

<!-- 请求方式的示例 -->
<form action="account/saveAccount" method="post">
    <input type="submit" value="保存账户，post 请求">
</form>

<hr/>
<a href="account/removeAccount?accountName=aaa&money=100">删除账户1</a>
<a href="account/removeAccount?accountName=aaa&money=150">删除账户2</a>

<hr/>
<!-- requestParams 注解的使用 -->
<a href="account/useRequestParam?username=bruceliu">requestParam 注解</a>

<hr/>
<!-- request body 注解 -->
<form action="account/useRequestBody" method="get">
    用户名称：<input type="text" name="username" ><br/>
    用户密码：<input type="password" name="password" ><br/>
    用户年龄：<input type="text" name="age" ><br/>
    <input type="submit" value="保存">
</form>

<hr/>
<!-- PathVariable 注解 -->
<a href="account/usePathVariable/100">pathVariable 注解</a>

<hr>
<h1>新增账户</h1>
<!-- 保存 -->
<form action="springmvc/testRestPOST" method="post">
    用户名称：<input type="text" name="username"><br/>
    <input type="submit" value="保存">
</form>


<!-- 删除 -->
<form action="springmvc/testRestDELETE/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="删除">
</form>

<!-- 查询一个 -->
<form action="springmvc/testRestGET/1" method="post">
    <input type="hidden" name="_method" value="GET">
    <input type="submit" value="查询">
</form>


<!-- 更新 -->
<form action="springmvc/testRestPUT/1" method="post">
    用户名称：<input type="text" name="username"><br/>
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="更新">
</form>

<hr/>

<!-- RequestHeader 注解 -->
<a href="springmvc/useRequestHeader">获取请求消息头</a>

<!-- CookieValue 注解 -->
<a href="springmvc/useCookieValue">绑定 cookie 的值</a>

<hr/>
<!-- ModelAttribute 注解的基本使用 -->
<a href="springmvc/testModelAttribute?username=bruceliu">测试 modelattribute</a>


<hr/>
<!-- 修改用户信息 -->
<form action="springmvc/updateUser" method="post">
    <input type="hidden" value="2" name="id"/>
    用户名称：<input type="text" name="username" ><br/>
    用户年龄：<input type="text" name="age" ><br/>
    <input type="submit" value="保存">
</form>

<hr/>

<!-- SessionAttribute 注解的使用 -->
<a href="springmvc/testPut">存入 SessionAttribute</a> <hr/>

<a href="springmvc/testGet">取出 SessionAttribute</a> <hr/>
>
<a href="springmvc/testClean">清除 SessionAttribute</a>

</body>
</html>
