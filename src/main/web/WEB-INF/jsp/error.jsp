<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/26 0026
  Time: 下午 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="basic.jsp"%>
<head>
    <title>error</title>
</head>
<body>
<div>
    <img src="/statics/images/error/error.jpg"  style="" <%--onload="AutoResizeImage(4000,0,this)"--%> alt="time">
    <div><a href="${pageContext.request.contextPath}/main/queryAllMain">返回首页</a></div>

</div>
</body>
<script type="text/javascript">

    /*按比例调整图片的大小*/
    function AutoResizeImage(maxWidth,maxHeight,objImg){
        var img = new Image();
        img.src = objImg.src;
        var hRatio;
        var wRatio;
        var Ratio = 1;
        var w = img.width;
        var h = img.height;
        wRatio = maxWidth / w;
        hRatio = maxHeight / h;
        if (maxWidth ==0 && maxHeight==0){
            Ratio = 1;
        }else if (maxWidth==0){//
            if (hRatio<1) Ratio = hRatio;
        }else if (maxHeight==0){
            if (wRatio<1) Ratio = wRatio;
        }else if (wRatio<1 || hRatio<1){
            Ratio = (wRatio<=hRatio?wRatio:hRatio);
        }
        if (Ratio<1){
            w = w * Ratio;
            h = h * Ratio;
        }
        objImg.height = h;
        objImg.width = w;
    }
</script>
</html>
