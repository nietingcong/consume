package com.wiseweb.ntc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_role")
public class Role extends IdEntity {
	private String name;
	private Integer level;
	private Long parentId;
	private Integer nodeType;
	private List<Menu> menus;//many-to-many
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="level")
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	@Column(name="parent_id")
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	@Column(name="node_type")
	public Integer getNodeType() {
		return nodeType;
	}
	public void setNodeType(Integer nodeType) {
		this.nodeType = nodeType;
	}
	
	@ManyToMany(cascade=CascadeType.REFRESH,targetEntity=Menu.class)
	@JoinTable(name="tb_role_menu",joinColumns=@JoinColumn(name="role_id"),
			inverseJoinColumns=@JoinColumn(name="menu_id"))
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
}
