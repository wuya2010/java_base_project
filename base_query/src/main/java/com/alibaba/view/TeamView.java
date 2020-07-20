package com.alibaba.view;

/*
用来交互
 */


import com.alibaba.bean.Employee;
import com.alibaba.bean.Programmer;
import com.alibaba.service.NameListService;
import com.alibaba.service.TeamService;
import com.alibaba.utils.TSUtility;
import com.alibaba.utils.TeamException;

public class TeamView {
    //私有化对象
    private NameListService listService = new NameListService();
    private TeamService teamService = new TeamService();

    //删除团队成员
    private void deleteMember(){
        System.out.println("-----------------------------------------------------------");
        System.out.print("请输入要删除员工的TID：");
        int tid = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N):");
        char confirmSelection = TSUtility.readConfirmSelection();
        if(confirmSelection == 'Y'){
            try {
                //根据id进行删除
                teamService.removeMember(tid);
                System.out.println("删除成功");
            } catch (TeamException e) {
                System.out.println(e.getMessage());
            }
            //回车键继续
          TSUtility.readReturn();
        }
    }

    //添加成员
    public void addMember(){
        System.out.println("--------------------------------------------------------------------------");
        System.out.print("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        try {
            //获取对应id的employee
            Employee employee = listService.getEmployee(id);
            //将id放入team中
            teamService.addMember(employee);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        //回车键继续
    TSUtility.readReturn();
    }

//3.显示所有成员
    public void listAllMember(){
        System.out.println("--------------------团队成员列表---------------------");
        System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");

        //所有团队成员
        //获取team的成员
        Programmer[] team = teamService.getTeam();
        //遍历成员
        for(int i  = 0 ; i< team.length; i++){
            Programmer p = team[i];
            //显示每个i对应的member
            System.out.println(p.getMemberDes());
        }
        System.out.println("--------------------------------------------------");
        TSUtility.readReturn();
    }

  //4. 显示所有的公司员工
/*  public void listAllEmployees(){
        //对象调用方法
        Employee[] allEmployees = listService.getAllEmployee();
    *//*    //定义一个空的数组
        Employee[]  employee;*//*

      for (int i = 0 ; i< allEmployees.length;i++){
          System.out.println(allEmployees[i]);
        }
  }*/
    private void listAllEmployees() {
        // 1.获取公司所有的成员
        Employee[] allEmployees = listService.getAllEmployee();
        // 遍历数组
        for (int i = 0; i < allEmployees.length; i++) {
            Employee employee = allEmployees[i];
            // 多态
            System.out.println(employee.toString());
        }
    }



  //5. 进入主菜单
  public void enterMainMenu() {
      boolean isFlag = true;
      do {
          System.out.println("-------------------------------开发团队调度软件--------------------------------");
          System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
          listAllEmployees();// 展示公司所有的成员
          System.out.println("--------------------------------------------------------------------------");
          System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
          // 读取菜单项
          char menuSelection = TSUtility.readMenuSelection();
          // 判断
          switch (menuSelection) {
              case '1':
                  listAllMember(); //显示团队中所有的成员
                  break;
              case '2':
                  addMember();//添加团队中所有的成员
                  break;
              case '3':
                  deleteMember();//删除团队中所有的成员
                  break;
              case '4':
                  //退出
                  System.out.print("确认是否退出:(Y/N):");
                  //读取是否退出
                  char confirmSelection = TSUtility.readConfirmSelection();
                  if(confirmSelection == 'Y'){
                      isFlag = false;
                      System.out.println("退出成功");
                  }
                  break;
          }
      } while (isFlag);
  }

  public static void main(String[] args){
        new TeamView().enterMainMenu();
  }
}
