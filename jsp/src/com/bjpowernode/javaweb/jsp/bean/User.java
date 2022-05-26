package com.bjpowernode.javaweb.jsp.bean;

/**
 * 符合javabean规范的一个java类。
 */
public class User {
    private String username;
    private String password;
    private int age;
    private Address addr;

    public Address getAddr222() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    /*@Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }*/

    public User() {
    }

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public String getUsername() {
        System.out.println("getUsername()方法执行了");
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        System.out.println("getPassword()方法执行了");
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 或者getage()
    // java程序员给方法起名的时候，建议驼峰。
    public int getAge() {
        System.out.println("getAge()方法执行了");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 这个方法只是一个get方法而已。类中并没有声明email属性。
     * 使用EL表达式可以获取Email吗？
     * @return
     */
    public String getEmail(){
        return "dujubin@126.com";
    }
}
