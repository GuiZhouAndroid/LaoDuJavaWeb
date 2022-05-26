<%@page contentType="text/html;charset=UTF-8" %>

<%
    request.setAttribute("username", "zhangsan");
%>

<%--取出数据并且输出到浏览器--%>
<%=request.getAttribute("username")%>
采用EL表达式：${username}

<br>

<%=request.getAttribute("usernam")%>

<%--EL表达式主要任务是做页面展示，要求最终页面展示上是友好的。--%>
<%--所以EL表达式对null进行了处理。如果是null，则在浏览器上显示空白。--%>
采用EL表达式：${usernam}

<hr>
<%--EL表达式表面上是这种写法，实际上运行的时候，还是要翻译生成java代码的。--%>
${usernam} 这个EL表达式等同于这一段java代码：<%=request.getAttribute("usernam") == null ? "" : request.getAttribute("usernam")%>