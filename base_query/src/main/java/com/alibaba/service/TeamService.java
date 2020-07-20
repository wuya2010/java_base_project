package com.alibaba.service;


import com.alibaba.bean.*;
import com.alibaba.utils.TeamException;

/*
员工不存在； 成员已满； 成员不是开发人员； 员工已是开发人员

对团队成员进行管理：
1. 获取团队成员；
2. 添加团队成员；
3. 删除团队成员

 */
public class TeamService {

    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team  = new Programmer[MAX_MEMBER];
    private int total = 0 ;

    //1. 获取团队中的成员
    public Programmer[] getTeam(){
        //定义一个数组，放置对象
        Programmer[] p = new Programmer[total];
        //遍历total
        for(int i = 0; i< total; i++){
            p[i] = team[i];
        }
        return p;
    }

    //2. 添加成员
    public void addMember(Employee e) throws TeamException {
        //1. 人数超过
        if(total >= team.length){
            throw new TeamException("成员已满");
        }

        //不是开发
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }

        //3. 以是乘员
        for(int i = 0; i < total;i++){
           if(team[i].getId() == e.getId()){
               throw new TeamException("该员已是团队成员 ");
           }
        }

        //4.正在休假  ==》 为什么进行转换
        Programmer p = (Programmer) e;
        if(p.getStatus()== Status.VOCATION){
            throw new TeamException("该员正在休假，无法添加");
        }

        //人员增加和判断
        int arcCount = 0; //架构师的人数
        int desCount = 0; //设计师的人数
        int proCount = 0;

        for(int i = 0 ; i< total; i++){
            Programmer pro = team[i];
            if(pro instanceof Architect){
                arcCount++;
            }else if(pro instanceof Designer){
                desCount++;
            }else if(pro instanceof Programmer){
                proCount++;
            }
        }
        if(e instanceof Architect){
            if(arcCount >= 1){
                throw new TeamException("团队中只能有一名架构师");
            }
        }else if(e instanceof Designer){
            if(desCount >= 2){
                throw new TeamException("团队中只能有两名设计师");
            }
        }else if(e instanceof Programmer){
            if(proCount >= 3){
                throw new TeamException("团队中只能有三名程序员");
            }
        }

        //添加团队成员
        p.setMemberId(counter);
        counter++;
        p.setStatus(Status.BUSY);
        //把p放到数组中
        team[total] = p ;
        total++;
    }


    public void removeMember(int memberId) throws TeamException{
     // 初始化i值
        int i = 0;
    //1. 改变状态
        for(;i<total;i++){
            Programmer p = team[i];
            if(p.getMemberId()==memberId){
                p.setStatus(Status.FREE);
                break;
            }

        }
      //2. 如果大于报错
        if(i>=total){
            throw new TeamException("没有找到要删除的员工");
        }else{
            //删除的逻辑
          for(int j=i;j<total-1;j++){
              team[j]=team[j+1];
          }
              team[total-1]=null;
                total--;
        }

    }




}
