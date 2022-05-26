<%@ page import="com.bjpowernode.javaweb.jsp.bean.User" %>
<%@ page import="com.bjpowernode.javaweb.jsp.bean.Address" %>
<%@page contentType="text/html;charset=UTF-8" %>

<%
    // 创建User对象
    User user = new User();
    user.setUsername("jackson");
    user.setPassword("1234");
    user.setAge(50);

    // 创建地址Address对象
    Address a = new Address();
    a.setCity("北京");
    a.setStreet("大兴区");
    a.setZipcode("11111111");

    user.setAddr(a);

    // 将User对象存储到request域当中
    request.setAttribute("userObj", user);
%>

<%--使用EL表达式，从request域当中，取出User对象，并将其输出到浏览器--%>
<%--1. EL表达式会自动从某个范围中取数据。2. 将其转成字符串。 3. 将其输出到浏览器。--%>
${userObj}

<br>
<%--你想输出的是user对象的username属性--%>
${userObj.username}
<br>
<%--输出password--%>
${userObj.password}
<br>
<%--输出年龄age--%>
${userObj.age}
<br>
<%--输出email--%>
${userObj.email}

<br>
<%--在EL表达式中不能添加双引号，如果添加了双引号，EL表达式就会将其当做普通的字符串输出到浏览器。--%>
${"userObj"}
userObj

<br>
<%--取出User对象是哪个城市的？--%>
城市:${userObj.addr222.city}
街道：${userObj.addr222.street}
邮编：${userObj.addr222.zipcode}
