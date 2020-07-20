package com.alibaba.bean;

public class Designer extends Programmer {
    private double bonus;

    public Designer(){
        super();
    }

    public Designer(int id, String name, int age, double salary,
                    Equipment equipment,double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    //这里是所有信息的展示
    @Override
    public String toString() {
        return getEmployeeInfo()+ "\t设计师\t" + getStatus() +"\t" + getBonus() + "\t"
                + getEquipment().getDescription();
    }

    //这里的是团队成员的描述
    @Override
    public String getMemberDes(){
        return getMemberId()+"/"+getId() + "\t" + getName() + "\t" + getAge()
                + "\t" + getSalary() + "\t设计师\t" + getBonus();
    }



    public double getBonus(){
        return bonus;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }


}
