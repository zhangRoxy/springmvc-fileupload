<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    <a href="/account/findAccount?accountId=10&accountName=zhangsan">查询账户</a>
</h2>
<hr/>
<form action="/account/saveAccount" method="get">
    账户名:<input type="text" name="name"/><br/>
    账户金额:<input type="text" name="money"/><br/>
    账户省份:<input type="text" name="address.provinceName"/><br/>
    账户城市:<input type="text" name="address.cityName"/><br/>
    <input type="submit" value="存钱"/>
</form>
<hr/>

<!-- 特殊情况之：类型转换问题 -->
<a href="account/deleteAccount?date=2018-01-01">根据日期删除账户</a>

<hr/>

<!-- 原始 ServletAPI 作为控制器参数 -->
<a href="account/testServletAPI">测试访问 ServletAPI</a>

</body>
</html>
