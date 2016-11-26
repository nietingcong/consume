package com.wiseweb.ntc.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tb_user")
public class User extends IdEntity {
	private String name;
	private String loginName;
	private String passWord;
	private String email;
	private String sex;
	private Date createTime;
	private Boolean validateTime;
	
	private Department departmentId;//many-to-one
	private Set<Role> roles;//many-to-many
	
	private List<Menu> menus;
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="login_name")
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@Column(name="password")
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="sex")
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Column(name="ctime")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name="validate_time")
	public Boolean getValidateTime() {
		return validateTime;
	}
	public void setValidateTime(Boolean validateTime) {
		this.validateTime = validateTime;
	}
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="department_id")
	public Department getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}
	@ManyToMany(cascade=CascadeType.REFRESH,targetEntity=Role.class)
	@JoinTable(name="tb_user_role",joinColumns=@JoinColumn(name="user_id"),
				inverseJoinColumns=@JoinColumn(name="role_id"))	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Transient
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
}
