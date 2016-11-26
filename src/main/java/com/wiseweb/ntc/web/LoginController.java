package com.wiseweb.ntc.web;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.CDATA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wiseweb.ntc.comment.util.ValidateCodeUtil;
import com.wiseweb.ntc.entity.Menu;
import com.wiseweb.ntc.entity.Role;
import com.wiseweb.ntc.entity.User;
import com.wiseweb.ntc.service.UserMng;

@Controller
@RequestMapping(value="/")
public class LoginController {
	@Autowired
	private UserMng userMng;
	private static final String VALIDATE_CODE = "VALIDATE_CODE_KEY";
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("cUser");
		if(user == null) {
			return "login";
		}
		return "index";
	}
	
	/**
	 * 登录出现异常时，shiro放行然后执行此方法
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(HttpServletRequest request,ModelMap map) {
		Object error = request.getAttribute("shiroLoginFailure");
		if (error != null) {
			map.addAttribute("error", error);
		}
		return "login";
	}
	
	@RequestMapping(value="index")
	public String login(String code,HttpServletRequest request,ModelMap map) {
		
		User user = (User)request.getSession().getAttribute("cUser");
		user = userMng.findByName(user.getLoginName());
		List<Menu> uMenus = new ArrayList<Menu>();
		for(Role role : user.getRoles()){
			List<Menu> menus = role.getMenus();
			System.out.println(menus.size());
			for (Menu menu : menus) {
				if(menu.getParentMenu() != null) continue;
				uMenus.add(menu);
				System.out.println(menu.getName());
			}
		};
		map.put("user", user);
		map.put("menus", uMenus);
		return "index";
	}
	
	@RequestMapping(value="validateCode",method=RequestMethod.GET)
	public void getValidateCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("image/jpeg");
		String code = ValidateCodeUtil.generateTextCode(ValidateCodeUtil.TYPE_NUM_ONLY, 4, null);
		request.getSession().setAttribute(VALIDATE_CODE, code);
		BufferedImage bim = ValidateCodeUtil.generateImageCode(code, 80, 25, 3, true, Color.WHITE, Color.BLACK, null);
		ImageIO.write(bim, "JPEG", response.getOutputStream());
	}
}
