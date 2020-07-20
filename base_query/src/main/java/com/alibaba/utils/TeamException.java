package com.alibaba.utils;

//自定义exception
//这个需要巩固一下
public class TeamException extends Exception{

	private static final long serialVersionUID = -4442554082261643598L;

	public TeamException(){
		
	}
	
	public TeamException(String message){
		super(message);
	}
}
