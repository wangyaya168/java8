package com.king.design.pattern.vister;

/**
 * 
 * @description: 访问者模式
 * @author: wangya
 * @date: 2019/03/25 14:22
 */
public abstract class Employee {

	public final static int MALE = 0;

	public final static int FEMALE = 1;

	private String name;

	private int salary;

	private int age;

	private int sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public final void report() {
		String info = "姓名：" + name + "\t";
		info = info + "性别：" + sex + "\t";
		info = info + "薪资" + salary + "\t";
		info = info + this.getOtherInfo();
		System.out.println(info);
	}

	protected abstract String getOtherInfo();
}
