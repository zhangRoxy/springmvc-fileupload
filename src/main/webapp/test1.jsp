<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script> <script type="text/javascript">

    $(function(){
        $("#testJson").click(function(){
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/testResponseJson",
                contentType:"application/json;charset=utf-8",
                data:'{"id":1,"name":"test","money":999.0}',
                dataType:"json",
                success:function(data){
                    //alert(data); //JSON对象
                    alert(JSON.stringify(data)); //JSON字符串
                }
            });
        });
    })

</script>
</head>
<body>

<!-- 测试异步请求 -->
<input type="button" value="测试 ajax 请求 json 和响应 json" id="testJson"/>

</body>
</html>
