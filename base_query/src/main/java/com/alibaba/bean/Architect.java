package com.alibaba.bean;

/**
 * @author kylinWang
 * @data 2020/7/18 11:01
 */

public class Architect extends Designer {
    private int stock;

    public Architect() {
        super();
    }

    public Architect(int id, String name, int age, double salary,
                     Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
    }

    @Override
    public String toString() {
        return getEmployeeInfo() + "\t加构师\t" + getStatus() +"\t" + getBonus()
                + "\t" + getStock() + "\t"
                + getEquipment().getDescription();//多态
    }

    @Override
    public String getMemberDes(){
        return getMemberId()+"/"+getId() + "\t" + getName() + "\t" + getAge()
                + "\t" + getSalary() + "\t架构师\t" + getBonus() + "\t" + getStock();
    }

    // set / get 方法
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
