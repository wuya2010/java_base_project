package com.alibaba.bean;

public class Employee {

    private int id;
    private String name;
    private int age;
    private double salary;

    //构造器的结构 Employee()
    public Employee() {
        super();
    }
    public Employee(int id, String name, int age, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getEmployeeInfo(){
        return id+"\t"+name+"\t"+age+"\t"+salary;
    }

    @Override
    public String toString() {
        return getEmployeeInfo();
    }

    //重写get/ set 方法
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
