package com.wiseweb.ntc.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tb_menu")
public class Menu extends IdEntity {
	private String name;
	private String url;//资源路径
	private Menu parentMenu;//父菜单
	private Integer nodeType;//层级
	private Integer orderType;//排序
	
	private List<Menu> childMenus;
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(name="node_type")
	public Integer getNodeType() {
		return nodeType;
	}
	public void setNodeType(Integer nodeType) {
		this.nodeType = nodeType;
	}
	@Column(name="order_type")
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	@ManyToOne
	@JoinColumn(name="parent_id")
	public Menu getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}
	@OneToMany(targetEntity=Menu.class,mappedBy="parentMenu")
	public List<Menu> getChildMenus() {
		return childMenus;
	}
	public void setChildMenus(List<Menu> childMenus) {
		this.childMenus = childMenus;
	}
	
}
