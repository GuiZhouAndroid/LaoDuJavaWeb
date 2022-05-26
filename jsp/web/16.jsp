<%@ page import="com.bjpowernode.javaweb.jsp.bean.Student" %>
<%@page contentType="text/html;charset=UTF-8" %>

<%--
    关于EL表达式中的运算符
        1. 算术运算符
            + - * / %
        2. 关系运算符
            == != > >= < <= eq
        3. 逻辑运算符
            ! && || not and or （注意：!和not都是取反）
        4. 条件运算符
            ? :
        5. 取值运算符：
            [] 和 .
        6. empty 运算符
--%>
${10 + 20} <br>

<%-- 在EL表达式当中“+”运算符只能做求和运算。不会进行字符串拼接操作。 --%>
<%--"20"会被自动转换成数字20--%>
${10 + "20"} <br>

<%-- java.lang.NumberFormatException: For input string: "abc" --%>
<%-- + 两边不是数字的时候，一定会转成数字。转不成数字就报错：NumberFormatException--%>
\${10 + "abc"} <br>

\${"king" + "soft"} <br>

<%-- 关系运算符 --%>
${"abc" == "abc"} <br>
${"abc"} == ${"abc"} <br>

<%
    Object obj = new Object();
    request.setAttribute("k1", obj);
    request.setAttribute("k2", obj);
%>
${k1 == k2} <br> <%--true--%>

<%
    String s1 = new String("hehe");
    String s2 = new String("hehe");
    request.setAttribute("a", s1);
    request.setAttribute("b", s2);
%>
${a == b} <%--true--%> <br>

<%
    Object o1 = new Object();
    Object o2 = new Object();
    request.setAttribute("o1", o1);
    request.setAttribute("o2", o2);
%>
${o1 == o2} <br> <%--false--%>

<%
    Student stu1 = new Student("110", "警察");
    Student stu2 = new Student("110", "警察");

    request.setAttribute("stu1", stu1);
    request.setAttribute("stu2", stu2);
%>

<%--EL表达式当中的 "==" 调用了equals方法。--%>
\${stu1 == stu2} <br>
\${stu1 eq stu2} <br>

<hr>
<%-- != 也会调用对象的equals方法。--%>
${stu1 != stu2} <br>
${200 != 200} <br>

<%--以下语法错误，没有加小括号--%>
\${!stu1 eq stu2} <br>
<%--正确的--%>
${!(stu1 eq stu2)}<br>
${not(stu1 eq stu2)}<br>

<%--条件运算符--%>
${empty param.username ? "对不起，用户名不能为空！" : "欢迎访问！！！！" }


<hr>
<%--empty运算符：运算结果是boolean类型。--%>
<%--判断是否为空，如果为空，结果是true。如果不为空，结果是false--%>
${empty param.username} <br>
${!empty param.username} <br>
${not empty param.username} <br>

<hr>
<%--结果false--%>
<%--前半部分是boolean类型。后面是null--%>
${empty param.password == null} <br>
${(empty param.password) == null} <br>

${param.password == null} <br>



























