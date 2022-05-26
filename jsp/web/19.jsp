<%@ page import="com.bjpowernode.javaweb.jsp.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--var用来指定循环中的变量--%>
<%--begin开始--%>
<%--end结束--%>
<%--step步长--%>
<%--底层实际上：会将i存储到pageContext域当中。--%>
<c:forEach var="i" begin="1" end="10" step="1">
    <%--所以这里才会使用EL表达式将其取出，一定是从某个域当中取出的。--%>
    ${i}<br>
</c:forEach>

<%
    // 创建List集合
    List<Student> stuList = new ArrayList<>();

    // 创建Student对象
    Student s1 = new Student("110", "经常");
    Student s2 = new Student("120", "救护车");
    Student s3 = new Student("119", "消防车");

    // 添加到List集合中
    stuList.add(s1);
    stuList.add(s2);
    stuList.add(s3);

    // 将list集合存储到request域当中
    request.setAttribute("stuList", stuList);
%>

<hr>
<%--var="s"这个s代表的是集合中的每个Student对象--%>
<%--varStatus="这个属性表示var的状态对象，这里是一个java对象，这个java对象代表了var的状态"--%>
<%--varStatus="这个名字是随意的"--%>
<%--varStatus这个状态对象有count属性。可以直接使用。--%>
<c:forEach items="${stuList}" var="s" varStatus="stuStatus">
    <%--varStatus的count值从1开始，以1递增，主要是用于编号/序号。--%>
    编号：${stuStatus.count},id:${s.id},name:${s.name} <br>
</c:forEach>

