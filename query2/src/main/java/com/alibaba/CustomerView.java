package com.alibaba;

import com.alibaba.bean.Customer;

import java.util.List;
import java.util.Scanner;

/**
 * @author kylinWang
 * @data 2020/7/18 18:53
 *
 * server: 实现交户
 */
public class CustomerView {
    private CustomerList list; //定义一个对象

    public CustomerView() {
        list = new CustomerList(10);
    }


    //进入菜单
    public void enterMenu(){

        Boolean flag = true;
      do {
          System.out.println("-----------------客户信息管理软件-----------------");
          System.out.println("                 1 添 加 客 户");
          System.out.println("                 2 修 改 客 户");
          System.out.println("                 3 删 除 客 户");
          System.out.println("                 4 客 户 列 表");
          System.out.println("                 5 退       出");
          System.out.print("                   请选择(1-5)：");
          //todo: 非静态方法不能被直接引用
          char ch = CMUtils.readMenuSelection();//只能读选定的数据
          //循环目录
          switch (ch) {
              case '1': {
                  addNewCustomer();
              }
              case '2': {
                  modifyCustomer();
              }
              case '3': {
                  deleteCustomer();
              }
              //显示所有客户列表
              case '4': {
                  listAllCustomer();
              }
              case '5': {
                  //如果输入‘y’ 退出
                  System.out.print("确认是否退出(Y/N):");
                  char  isQuit = CMUtils.readMenuSelection(); //
                  if("Y".equals(isQuit)){
                      flag = false;
                      System.out.println("退出");
                  }
              }
          }
      }while(flag);
    }


    public void addNewCustomer(){
        System.out.println("---------------------添加客户---------------------");
        //1.读取数据
        System.out.print("姓名:");
        String name = CMUtils.readString(8);
        System.out.print("性别:");
        char gender = CMUtils.readChar();
        System.out.print("年龄:");
        int age = CMUtils.readInt();
        System.out.print("电话:");
        String phone = CMUtils.readString(16);
        System.out.print("邮箱:");
        String email = CMUtils.readString(30);

        //调用方法: name , gender , age ,  phone, email
        Customer customer = new Customer(name, gender, age, phone, email);
        Boolean  isAdd = list.addCustomer(customer);
        if(isAdd){ //本来就是boolean, 无需再判断
            System.out.println("---------------------添加完成---------------------");
        }else{
            System.out.println("---------------------添加失败---------------------");
        }

    }

    //todo: 修改
    public void modifyCustomer(){
        System.out.println("---------------------修改客户---------------------");
        boolean isFlag = true;
        Customer customer = null;
        int id = 0;
        while(isFlag){
            System.out.print("请选择待修改客户编号(-1退出)：");
            //读取编号
            id = CMUtils.readInt();
            //判断如果是-1则退出
            if(id == -1){
                return;
            }
            //如果不是-1则获取该用户
            customer = list.getCustomer(id - 1);
            //判断用户是否存在
            if(customer == null){
                System.out.println("无法找到指定用户");
            }else{ //如果用户存在结束循环
                break;
            }
        }
		/*
		姓名(小井):
		性别(男):女
		年龄(18):20
		电话(110):120
		邮箱(aaa@qq.com):
		 */
        //读取数据
        System.out.print(" 姓名(" + customer.getName() + "):");
        //如果从键盘输入了名字那么就读取输入的名字，如果没有输入就读取默认的名字
        String name = CMUtils.readString(20, customer.getName());
        System.out.print(" 性别(" + customer.getGender() + "):");
        //如果从键盘输入了性别那么就读取输入的性别，如果没有输入就读取默认的性别
        char gender = CMUtils.readChar(customer.getGender());
        System.out.print(" 年龄(" + customer.getAge() + "):");
        //如果从键盘输入了年纪那么就读取输入的年纪，如果没有输入就读取默认的年纪
        int age = CMUtils.readInt(customer.getAge());
        System.out.print(" 电话(" + customer.getPhone() + "):");
        String phone = CMUtils.readString(18, customer.getPhone());
        System.out.print(" 邮箱(" + customer.getEmail() + "):");
        String email = CMUtils.readString(30, customer.getEmail());
        //封装对象
        Customer cust = new Customer(name, gender, age, phone, email);
        //替换对象
        boolean replaceCustomer = list.replaceCusotmer(id - 1, cust);
        //判断替换是否成功
        if (replaceCustomer) {
            System.out.println("---------------------修改完成--------------------- ");
        } else {
            System.out.println("---------------------修改失败--------------------- ");
        }


    }

    // 删除用户
    public void deleteCustomer() {
/*
		 * ---------------------删除客户---------------------
			请选择待删除客户编号(-1退出)：3
			无法找到该用户
			请选择待删除客户编号(-1退出)：1
			确认是否删除(Y/N):Y
			---------------------删除完成---------------------
		 */
        System.out.println("---------------------删除客户---------------------");
        boolean isFlag = true;
        int id = 0;
        while (isFlag) {
            System.out.print("请选择待删除客户编号(-1退出)：");
            //1.读取输入的id
            id = CMUtils.readInt();
            //2.判断如果id为-1则退出
            if (id == -1) {
                return;
            }
            //3.用户是否存在
            Customer customer = list.getCustomer(id - 1);
            //4.判断用户是否为null
            if (customer == null) {
                System.out.println("无法找到该用户");
            } else { //如果用户存在则跳出循环
                break;
            }
        }
    }


    public void listAllCustomer(){
/*
		 * ---------------------------客户列表---------------------------
			编号	姓名	性别	年龄	电话		邮箱
			1	小井	男	18	110		aaa@qq.com
			2	小龙哥	男	16	15555555555		qq@qq.co
			--------------------------客户列表完成-------------------------
		 */
        System.out.println("---------------------------客户列表---------------------------");
        System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
        //1.从数组中获取数据
        Customer[] customers = list.getAllCustomers();
        if(customers.length == 0){
            System.out.println("还没有用户，赶紧去尚硅谷拉人去吧");
        }else{
            //展示所有的用户
            for (int i = 0; i < customers.length; i++) {
                //获取用户
                Customer customer = customers[i];
                //展示用户信息
                System.out.println(i + 1
                        + "\t" + customer.getName()
                        + "\t" + customer.getGender()
                        + "\t" + customer.getAge()
                        + "\t" + customer.getPhone()
                        + "\t" + customer.getEmail()
                );
            }
        }
        System.out.println("--------------------------客户列表完成-------------------------");
    }

    public static void main(String[] args) {
        //主程序入口
        new CustomerView().enterMenu();
    }

}
