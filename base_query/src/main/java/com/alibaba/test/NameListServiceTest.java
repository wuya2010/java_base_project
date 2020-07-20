package com.alibaba.test;


import com.alibaba.bean.Employee;
import com.alibaba.bean.Equipment;
import com.alibaba.bean.Programmer;
import com.alibaba.service.NameListService;
import com.alibaba.utils.TeamException;
import org.junit.Test;

public class NameListServiceTest {
    //测试指定的Id的员工
    @Test
    public void getEmployeeTest(){

        NameListService nameListService = new NameListService();

        Employee employee = null;
        try {
            employee = nameListService.getEmployee(10);
            System.out.println(employee.getName());
        } catch (TeamException e) {
            e.printStackTrace();
        }
    }

    //测试封装是否成功
    @Test
    public void getAllEmployeesTest(){
        NameListService nameListService = new NameListService();
        Employee[] allEmployees  = nameListService.getAllEmployee();

        for(int i = 0; i < allEmployees.length; i++){
            System.out.println(allEmployees[i].getName());

            Employee employee = allEmployees[i];
            if(employee instanceof Programmer){
                //可以将Programmer及子类都可以转成Programmer - 注意不能将父类转成Programmer
                Programmer p = (Programmer) employee;
                //获取该员工的设备 - 多态
                Equipment equipment = p.getEquipment();
                //获取设备的描述 - 实际上调用的是实现类的对象的getDescription()
                String description = equipment.getDescription();
                System.out.println();
            }
        }
    }
}
