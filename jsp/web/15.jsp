<%@page contentType="text/html;charset=UTF-8" %>

<%--JSP中EL表达式的隐含对象：
    1. pageContext
    2. param
    3. paramValues
    4. initParam
    5. 其他（不是重点）
--%>
应用的根路径：${pageContext.request.contextPath}<br>

<%--request是JSP九大内置对象之一。--%>
<%--request.getParameter("username") 获取请求的参数。--%>
<%--用户在浏览器上提交数据：http://localhost:8080/jsp/15.jsp?username=lisi --%>
用户名：<%=request.getParameter("username")%><br>
用户名：${param.username}<br>

<%--假设用户提交的数据：http://localhost:8080/jsp/15.jsp?aihao=smoke&aihao=drink&aihao=tangtou--%>
<%--以上提交的数据显然是采用checkbox进行提交的。同一组的checkbox的name是一样的。--%>
<%--param 获取的是请求参数一维数组当中的第一个元素。--%>
爱好：${param.aihao} <br>
爱好：<%=request.getParameter("aihao")%> <br>

一维数组：${paramValues.aihao}<br>
一维数组：<%=request.getParameterValues("aihao")%><br>

<%--获取数组当中的元素：[下标]--%>
爱好：${paramValues.aihao[0]}、${paramValues.aihao[1]}、${paramValues.aihao[2]} <br>

<%--EL表达式中的隐含对象：initParam--%>
<%--ServletContext是Servlet上下文对象，对应的JSP九大内置对象之一是：application --%>
<%
    String a = application.getInitParameter("pageSize");
    String b = application.getInitParameter("pageNum");
%>

每页显示的记录条数：<%=a%> <br>
页码：<%=b%> <br>

每页显示的记录条数：<%=application.getInitParameter("pageSize")%> <br>
页码：<%=application.getInitParameter("pageNum")%> <br>


每页显示的记录条数：${initParam.pageSize} <br>
页码：${initParam.pageNum} <br>