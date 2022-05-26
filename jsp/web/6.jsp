<%@page contentType="text/html;charset=UTF-8" %>

<%
    // 向request作用域当中存储username为zhangsan
    request.setAttribute("username", "zhangsan");
    request.setAttribute("obj", new Object());
%>

<%--将request域当中的数据取出来，并且还要输出到浏览器，使用java代码怎么办？--%>
<%=request.getAttribute("username")%>
<br>
<%=request.getAttribute("obj")%>
<br>

<hr>

<%--使用EL表达式呢？--%>
${username}
<br>
${obj}