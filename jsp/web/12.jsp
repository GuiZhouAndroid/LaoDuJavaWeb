<%@ page import="com.bjpowernode.javaweb.jsp.bean.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %>
<%@page contentType="text/html; charset=UTF-8" %>

<%
    // 数组对象
    String[] usernames = {"zhangsan", "lisi", "wangwu"};

    // 向域中存储数组
    request.setAttribute("nameArray", usernames);

    User u1 = new User();
    u1.setUsername("zhangsan");

    User u2 = new User();
    u2.setUsername("lisi");

    User[] users = {u1, u2};

    request.setAttribute("userArray", users);

    List<String> list = new ArrayList<>();
    list.add("abc");
    list.add("def");

    request.setAttribute("myList", list);

    Set<String> set = new HashSet<>();
    set.add("a");
    set.add("b");

    request.setAttribute("set", set);
%>

<%--取出set集合--%>
set集合：${set}
<%--无法获取：PropertyNotFoundException: 类型[java.util.HashSet]上找不到属性[0]--%>
<%--${set[0]}--%>
<hr>

<%--取出List集合--%>
<%--list集合也是通过下标的方式取数据的。--%>
${myList}
${myList[0]}
${myList[1]}
<hr>

<%--取出数组中第二个用户的用户名--%>
${userArray[1].username}
<hr>

<%--使用EL表达式取出数组中的元素--%>
${nameArray} <%--将数组对象直接输出--%>
${nameArray[0]} <%--取出数组中的第一个元素--%>
${nameArray[1]}
${nameArray[2]}

<%--取不出数据，在浏览器上直接显示的就是空白。不会出现数组下表越界。--%>
${nameArray[100]}