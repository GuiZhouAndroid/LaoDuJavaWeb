<%@ page import="com.bjpowernode.javaweb.jsp.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8" %>

<%--引入标签库。这里引入的是jstl的核心标签库。--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--格式化标签库，专门负责格式化操作的。--%>
<%--<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>--%>

<%--sql标签库--%>
<%--<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>--%>

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

<%--需求：将List集合中的元素遍历。输出学生信息到浏览器--%>
<%--使用java代码--%>
<%
    // 从域中获取List集合
    List<Student> stus = (List<Student>)request.getAttribute("stuList");
    // 编写for循环遍历list集合
    for(Student stu : stus){
%>
    id:<%=stu.getId()%>,name:<%=stu.getName()%><br>
<%
    }
%>

<hr>

<%--使用core标签库中forEach标签。对List集合进行遍历--%>
<%--EL表达式只能从域中取数据。--%>
<%--var后面的名字是随意的。var属性代表的是集合中的每一个元素。--%>
<c:forEach items="${stuList}" var="s">
    id:${s.id},name:${s.name} <br>
</c:forEach>


























