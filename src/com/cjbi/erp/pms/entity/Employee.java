package com.cjbi.erp.pms.entity;

import java.util.Date;

public class Employee {
	
	private Integer id ;//编号
	private String name;//姓名
	private String gender;//性别
	private Date birth;//出生日期
	private String email;//邮箱
	private String contact;//联系
	private Department department;//部门
	private Date createTime;// 不能被修改
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", birth=" + birth + ", email=" + email
				+ ", contact=" + contact + ", department=" + department + ", createTime=" + createTime + "]";
	}
	
	
	
}
