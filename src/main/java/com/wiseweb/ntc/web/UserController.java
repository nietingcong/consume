package com.wiseweb.ntc.web;

import java.util.Date;
import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.crypto.hash.SimpleHashRequest;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wiseweb.ntc.entity.User;
import com.wiseweb.ntc.service.UserMng;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserMng userMng;
	
	@RequestMapping("/test")
    public String test(ModelMap map,User user) {
    	String password =  new SimpleHash("md5","123",ByteSource.Util.bytes("ntc"),1).toHex();
        System.out.println("跳转成功！password="+password);
        List<User> userList = userMng.getAll(user);
        map.put("userList",userList);
        return "test";
    }
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String registUser(User user) {
		//对密码进行加密处理
		String password = new SimpleHash("md5", user.getPassWord(), ByteSource.Util.bytes(user.getLoginName()), 1).toHex();
		user.setPassWord(password);
		user.setCreateTime(new Date());
		userMng.save(user);
		return "login";
	}
}
