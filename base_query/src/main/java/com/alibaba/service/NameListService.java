package com.alibaba.service;


/*
每周对代码进行一次总结： 即使梳理思维
怎么在集群跑任务，这个确实要化时间好好总结一下
 */

import com.alibaba.bean.*;
import com.alibaba.utils.Data;
import com.alibaba.utils.TeamException;

public class NameListService {

    private Employee[] employees;

    //构造器，new时启动
    public NameListService(){
        employees = new Employee[Data.EMPLOYEES.length];

        for(int i = 0 ; i < Data.EMPLOYEES.length; i++){
            String type = Data.EMPLOYEES[i][0];

            //获取数据中的元素  id, name, age, salary
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String  name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            //分类 类型： int, String, 枚举； 对int类型进行匹配
            switch(Integer.parseInt(type)){
                case Data.EMPLOYEE:
                    Employee employee = new Employee(id, name, age, salary);
                    employees[i] = employee;
                    break;
                case Data.PROGRAMMER:
                    Programmer programmer = new Programmer(id, name, age, salary, createEquipment(i));
                    employees[i] = programmer;
                    break;
                case Data.DESIGNER:
                    Designer designer = new Designer(id, name, age, salary, createEquipment(i),Double.parseDouble(Data.EMPLOYEES[i][5]));
                    employees[i] = designer;
                    break;
                case Data.ARCHITECT:
                   Architect architect  = new Architect(id, name, age, salary, createEquipment(i),
                           Double.parseDouble(Data.EMPLOYEES[i][5]), Integer.parseInt(Data.EMPLOYEES[i][6]));
                    employees[i] = architect;
                    break;
            }
        }
    }


    //自定义一个方法； 返回值类型是 Equipment
    private Equipment createEquipment(int i) {
        //获取设备类型   pc:21, notebook: 22; printer: 23   model, display
        String type = Data.EQIPMENTS[i][0];

        switch(Integer.parseInt(type)){
            case Data.PC:
                return new PC(Data.EQIPMENTS[i][1],Data.EQIPMENTS[i][2]);
            case Data.NOTEBOOK:
                return new NoteBook(Data.EQIPMENTS[i][1],
                        Double.parseDouble(Data.EQIPMENTS[i][2]));
            case Data.PRINTER:
                return new Printer(Data.EQIPMENTS[i][1], Data.EQIPMENTS[i][2]);
        }
        return null;
    }

    //获取公司所有员工
    public Employee[] getAllEmployee(){
        return employees;
    }

    //获取指定id 的员工
    public Employee getEmployee(int id) throws TeamException {
        for(int i=0 ; i<employees.length; i++){
            Employee employee = employees[i];
            if (employee.getId() == id){
                return employee;
            }
        }

        throw new TeamException("没有找到");
    }
}
