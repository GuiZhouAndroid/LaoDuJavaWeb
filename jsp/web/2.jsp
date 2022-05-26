<%@page contentType="text/html; UTF-8" %>

System.out.println("hello jsp");

<%
    System.out.println("hello jsp");
%>

<!--HTML的注释，这个注释不专业，仍然会被翻译到java源代码当中。在JSP中不要使用这种注释-->

<%--JSP专业注释，这个注释信息不会被翻译到java源代码当中。建议使用这种注释方式。--%>
<%--报错原因：在service方法当中定义的变量不能使用private等访问权限修饰符修饰。--%>
<%--
    private int i;
--%>

<%--方法体当中，不能直接编写静态代码块，不能直接编写方法，方法套方法是不允许的。--%>
<%--
    static {
        System.out.println("静态代码块执行了");
    }
--%>

<%--
    public static void m(){
        System.out.println("m method execute");
    }
--%>

<%--
    System.out.println("num = " + num);
--%>

<%
    int num = 100;
%>

<%
    System.out.println("num = " + num);
%>

<%--错误原因：方法体当中的代码每一行都是一个java语句，java语句要以分号结尾。--%>
<%--
    System.out.println("hello world")
--%>