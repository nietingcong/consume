package com.wiseweb.ntc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wiseweb.ntc.entity.Menu;
import com.wiseweb.ntc.service.MenuMng;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuMng menuMng;
	
	@RequestMapping(value="/listAll")
	public String listAll(ModelMap map) {
		List<Menu> menus = menuMng.findAll();
		map.put("menus", menus);
		return "menu/list-all";
	}
}
