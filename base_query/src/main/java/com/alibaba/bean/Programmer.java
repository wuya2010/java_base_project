package com.alibaba.bean;

public class Programmer  extends Employee {

    private Status status = Status.FREE;
    private Equipment equipment;
    private int memberId;

    public Programmer(){
        super();
    }


    public Programmer(int id, String name, int age, double salary,Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getEmployeeInfo() + "\t程序员\t" + getStatus() +"\t\t\t"
                + getEquipment().getDescription();//多态
    }

    //get / set 方法
    public String getMemberDes(){
        return getMemberId()+"/"+getId() + "\t" + getName() + "\t" + getAge()
                + "\t" + getSalary() + "\t程序员";
    }

    public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Equipment getEquipment() {
        return equipment;
    }
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }



}

