package com.alibaba.bean;

/**
 * @author kylinWang
 * @data 2020/7/18 18:52
 */
public class Customer {

    // name , gender , age ,  phone, email
    private String name;
    private char gender;
    private int age;
    private String phone;
    private String email;

    //空参构造器
    public Customer() {
    }

    //含参构造器
    public Customer(String name, char gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
