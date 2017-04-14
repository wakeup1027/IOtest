package com.io.test.demo2;

import java.io.Serializable;

public class ioTest implements Serializable{
	private String name;
	private String sex;
	private String birthday;
	
	public ioTest(String name,String sex,String birthday){
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
