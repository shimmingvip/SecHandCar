package com.neusoft.action;
/**
 * 和登陆有关的都在这里
 */

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport {

	//登陆页面
	public String login() {
		return "success";
	}
   //退出
	public String tuichu() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.remove("userName");
		session.remove("userId");
		return "login";
	}
	
	//登录成功进入首页
	public String index(){
		return "success";
	}
}
