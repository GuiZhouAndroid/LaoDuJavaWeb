<%@page contentType="text/html;charset=UTF-8" %>
<%@page import="jakarta.servlet.http.HttpServletRequest"%>

<%--
// JSP有九大内置对象
// pageContext,request,session,application,response,out,config,page,exception
// 其中四个域对象，其中最小的域是pageContext
// pageContext翻译为：页面上下文。通过pageContext可以获取？？？？
--%>

<%--从以下代码来看，pageContext.getRequest() 方法是没用的。这是获取request对象。而JSP中自带了内置对象request，直接用request内置对象就行了。--%>
<%=pageContext.getRequest() %>
<br>
<%=request %>

<hr>

<%--
    在EL表达式当中没有request这个隐式对象。
    requestScope 这个只代表“请求范围”。不等同于request对象。
    在EL表达式当中有一个隐式的对象：pageContext
    EL表达式中的pageContext和JSP中的九大内置对象pageContext是同一个对象。
--%>
<%--<%=pageContext.getRequest() %>--%>
<%=((HttpServletRequest)pageContext.getRequest()).getContextPath() %>
这段java代码对应的EL表达式：
使用EL表达式来获取应用的根路径：
${pageContext.request.contextPath}


