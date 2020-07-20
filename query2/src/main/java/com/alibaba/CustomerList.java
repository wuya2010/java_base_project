package com.alibaba;

import com.alibaba.bean.Customer;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author kylinWang
 * @data 2020/7/18 18:52
 * 实现： 保存数据，修改数据，删除数据，获取数据
 */
public class CustomerList {
    private Customer[] ArrayCustomer;
    int total = 0;

    public CustomerList(int num) {
        ArrayCustomer =  new Customer[num]; //新建一个customer数组
    }

    //todo: 返回值类型 boolean
    public boolean addCustomer(Customer customer){
        if(customer == null){
            return false;
        }
        ArrayCustomer[total] = customer;
        total ++ ;
        return true;
    }

    //修改对应的index
    public boolean replaceCusotmer(int index, Customer customer){
        if(index >= total || index < 0){ //检查代码的合理性
            return false;
        }
        if(customer == null){
            return false;
        }
        ArrayCustomer[index] =  customer;
        return true;
    }


    //删除
    public Boolean deleteCustomer(int index){
        //校验  1.index的合理范围
        if(index < 0 || index >= total){
            return false;
        }

        for(int i = index ; i < total - 1; i++){
            ArrayCustomer[i] = ArrayCustomer[i + 1];
        }

        //最后一个元素设置成null
        ArrayCustomer[total - 1] = null;
        //总人数减1
        total--;

        return true;
    }

    public Customer[] getAllCustomers(){
        Customer[] cus = new Customer[total];
        for (int i = 0; i < total; i++) {
            cus[i] = ArrayCustomer[i];
        }
        return cus;
    }


    /**
     * 获取指定客户
     * @param index
     * @return
     */
    public Customer getCustomer(int index) {
        //校验 ：防止下角标越界
        if(index < 0 || index >= total){
            return null;
        }
        return ArrayCustomer[index];
    }
}
