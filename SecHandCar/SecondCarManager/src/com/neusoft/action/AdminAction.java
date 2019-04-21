package com.neusoft.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.neusoft.model.Admin;
import com.neusoft.model.Bid;
import com.neusoft.model.Car;
import com.neusoft.model.Customer;
import com.neusoft.service.AdminService;
import com.neusoft.utils.Pager;

@Controller("adminAction")
@Scope("prototype")
public class AdminAction extends ActionSupport implements ModelDriven<Admin>{

   private Admin admin;
   

@Override
   public Admin getModel() {
       if(admin==null) admin = new Admin();
     return admin;
   }
    @Autowired
   private AdminService adminService;
    
    /**
     * 登陆以后进入首页
     * @return
     * @throws IOException 
     */
    public void index() throws IOException{
        HttpServletResponse resp = ServletActionContext.getResponse();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = null;
        JSONObject json  = new JSONObject();
    	Admin ad1 =  adminService.getByUserName(admin);
    	 Admin ad =  adminService.login(admin);
    	if(ad1==null){
    		 json.put("result", 3); //该用户不存在
    	}else{
		   if(ad!=null){
	        	 json.put("result", 1); //登录成功
	        	 HttpSession session = ServletActionContext.getRequest().getSession();
	           session.setAttribute("userName", ad.getAdminName());
	           session.setAttribute("userId", ad.getId());
	           ActionContext.getContext().put("url", "/admin_admin.do");
	        }else{
	        	json.put("result",2);//密码错误
	        }
    	}
         out = resp.getWriter();
         out.write(json.toString());
		
    }
    
	     /**
		 * 列表
		 */
		public String admin(){
		Pager<Admin> pagers = adminService.findPager(admin);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("admin", admin);
		return SUCCESS;
		}
		
		
		/**
		 * 跳转到添加页面
		 * @return
		 */
		public String add(){
			return SUCCESS;
		}
		
		/**
		 * 执行添加
		 * @return
		 */
		public String exAdd(){
			adminService.save(admin);
			ActionContext.getContext().put("url", "/admin_admin.do");
			return "redirect";
		}
		
		/**
		 * 跳转修改页面
		 * @return
		 */
		public String update(){
			Admin ad = adminService.getById(admin.getId());
			ActionContext.getContext().put("admin", ad);
			return SUCCESS;
		}
	    
		/**
		 * 执行修改
		 * @return
		 */
		public String exUpdate(){
			adminService.update(admin);
			ActionContext.getContext().put("url", "/admin_admin.do");
			return "redirect";
		}
		
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			Admin a = adminService.getById(admin.getId());
			a.setIsDelete(1);
			adminService.update(a);
			ActionContext.getContext().put("url", "/admin_admin.do");
			return "redirect";
		}
	
	
	
	
}
