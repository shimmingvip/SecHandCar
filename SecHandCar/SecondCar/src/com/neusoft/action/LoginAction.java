package com.neusoft.action;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.neusoft.service.CarCategoryService;
import com.neusoft.service.CarService;
import com.opensymphony.xwork2.ActionContext;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction {
	  @Autowired
	    private CarService carService;
	     
	    @Autowired
	    private CarCategoryService carCategoryService;
	    
	//首页
	public String index() {
		return "success";
	}
	//登陆页面
	public String login() {
		return "success";
	}
   //注册页面
	public String register() {
		return "success";
	}
	
	   //退出
		public String tuichu() {
			ActionContext ac = ActionContext.getContext();
			Map session = ac.getSession();
			session.remove("customerName");
			session.remove("customerId");
			session.remove("customer");
			return "login";
		}
}
