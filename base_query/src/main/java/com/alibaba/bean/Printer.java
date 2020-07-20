package com.alibaba.bean;

public class Printer implements Equipment {

	private String type;
	private String name;

	public Printer() {
		super();
	}

	public Printer(String type, String name) {
		super();
		this.type = type;
		this.name = name;
	}
	
	/**
	 * 获取设备的详细信息
	 */
	@Override
	public String getDescription() {
		return name + "(" + type + ")";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
