<%@ page import="com.bjpowernode.javaweb.jsp.bean.User" %>
<%@page contentType="text/html;charset=UTF-8" %>

<%
    // 创建user对象
    User user = new User();
    user.setUsername("zhangsan");

    // 存储到request域当中。
    request.setAttribute("fdsafdsafdsa", user);

    // 向request域当中存储数据。
    request.setAttribute("abc.def", "hello jsp el!!!");
%>

<%--使用EL表达式取出，并且输出到浏览器--%>
<%--从域当中取user--%>
${fdsafdsafdsa}<br>

<%--取user的username--%>
<%----%>
${fdsafdsafdsa.username}<br>

<%--取user的username，注意[]当中的需要添加 双引号--%>
<%--[] 里面的没有加双引号的话，会将其看做变量。如果是带双引号 "username"，则去找user对象的username属性。--%>
${fdsafdsafdsa["username"]}<br>

<%--将数据取出并输出到浏览器--%>
${requestScope.abc.def}
之前是空白滴：
${requestScope["abc.def"]}
