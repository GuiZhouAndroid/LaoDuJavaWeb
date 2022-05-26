<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
    if(){

    }else if(){

    }else if(){

    }else if(){

    }else{

    }
--%>

<%--注意：这个嵌套结构不能随便改，只能这样嵌套。--%>
<c:choose>
    <c:when test="${param.age < 18}">
        青少年
    </c:when>
    <c:when test="${param.age < 35}">
        青年
    </c:when>
    <c:when test="${param.age < 55}">
        中年
    </c:when>
    <c:otherwise>
        老年
    </c:otherwise>
</c:choose>
