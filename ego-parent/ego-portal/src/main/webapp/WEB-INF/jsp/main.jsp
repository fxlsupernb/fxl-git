<%--
  Created by IntelliJ IDEA.
  User: fanxinglong
  Date: 2020-06-17
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>main</title>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            var index = 0;
            $(".index").eq(index).css("background-color","green");
            $.each($(".pic"),function (i,n) {
                $(n).css("left",400*i+"px");
            });
            setInterval(function () {
                $.each($(".pic"),function (i,n) {
                    $(n).animate({"left":parseInt($(n).css("left"))-400+"px"},1000,function () {
                        if (parseInt($(n).css("left"))==-400){
                            $(n).css("left","800px");
                        };
                    })
                })
                index++;
                index = index%3;
                $(".index").css("background-color","red");
                $(".index").eq(index).css("background-color","green");
            },3000);
            $(".index").click(function () {
                $(".index").css("background-color","red");
                $(this).css("background-color","green");
                var m = parseInt($(this).html())-1;
                $.each($(".pic"),function (i,n) {
                    var j = i-m;
                    var h;
                    if (j>=0){
                        h = j;
                    }else {
                        h = $(".pic").length+j;
                    }
                    index = m;
                    $(n).css("left",h*400+"px");
                });
            });
        })
    </script>
</head>
<body>
    <div style="margin:0 500px;border: 1px solid;width: 400px;height: 200px;position: absolute;overflow: hidden;">
        <c:forEach items="${pictures}" var="pic">
            <img class="pic" src="${pic.path}" style="width: 400px;height: 200px;position: absolute">
        </c:forEach>
    </div>
    <div style="position: absolute;margin: 180px 680px">
        <c:forEach begin="1" end="${pictures.size()}" var="step">
            <span class="index" style="background-color: red">${step}</span>
        </c:forEach>
    </div>
</body>
</html>
