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

import com.neusoft.model.Admin;
import com.neusoft.model.Car;
import com.neusoft.model.CarCategory;
import com.neusoft.model.Customer;
import com.neusoft.service.CustomerService;
import com.neusoft.service.CarCategoryService;
import com.neusoft.service.CarService;
import com.neusoft.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("customerAction")
@Scope("prototype")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

  private Customer customer;
   @Override
   public Customer getModel() {
       if(customer==null) customer = new Customer();
     return customer;
   }
   
   @Autowired
   private CustomerService customerService;
   
   
 private int carCategoryId;
   
   private String keyword;

   private String carPrice;
   
   private int carId;
   
   private String carIds;

   
   

    public String getCarIds() {
	return carIds;
}


public void setCarIds(String carIds) {
	this.carIds = carIds;
}


	public String getKeyword() {
        return keyword;
    }
    
    
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    
    public String getCarPrice() {
        return carPrice;
    }
    
    
    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }


    public int getCarCategoryId() {
        return carCategoryId;
    }
    
    
    
    public void setCarCategoryId(int carCategoryId) {
        this.carCategoryId = carCategoryId;
    }


   public int getCarId() {
		return carId;
	}


	public void setCarId(int carId) {
		this.carId = carId;
	}
	  @Autowired
	   private CarCategoryService carCategoryService;
	    
	    @Autowired
	   private CarService  carService;
   
        //注册
// 		public String register(){
// 		   String hql="from Customer bean where bean.loginName =:loginName ";
// 		   Map<String,Object> alias = new HashMap<String,Object>();
//    		   alias.put("loginName", customer.getLoginName() );
// 		   List<Customer> customerList=customerService.getByHQL(hql, alias);
// 			if(customerList.size() == 0){
// 				customerService.save(customer);
// 				return "login";
// 			}else{
// 				  return "register";
// 			}
// 		}
	    //注册
	    public void register() throws IOException{
	    	 HttpServletResponse resp = ServletActionContext.getResponse();
	         resp.setContentType("application/json;charset=UTF-8");
	         PrintWriter out = null;
	         JSONObject json  = new JSONObject();
	    	String hql="from Customer bean where bean.loginName =:loginName and bean.isDelete=0  ";
	    	 Map<String,Object> alias = new HashMap<String,Object>();
  		    alias.put("loginName", customer.getLoginName() );
		    List<Customer> customerList=customerService.getByHQL(hql, alias);
		    if(customerList.size() != 0){
		    	 json.put("result", 2);//该用户存在
 			}else{
 				customerService.save(customer);
 				 json.put("result", 1);//注册成功
 			}
		    out = resp.getWriter();
	        out.write(json.toString());
	    }
	    
	    
 		
 		//登录
// 		  public String login(){
// 			Customer c =customerService.login(customer);
// 			if(c == null){
// 				return "register";
// 			}else{
// 				 Pager<Car>  pagers=carService.findPager2(keyword,carPrice);
// 	    	    ActionContext.getContext().put("pagers", pagers);
// 	    	    String hql="from CarCategory where 1=1";
// 	            List<CarCategory> carCatList=carCategoryService.getByHQL(hql, null);
// 	            ActionContext.getContext().put("carCatList", carCatList); 
// 	            ActionContext.getContext().put("keyword2", keyword); 
// 			HttpSession session =ServletActionContext.getRequest().getSession();
// 			session.setAttribute("customerName", c.getCustomerName());
// 			session.setAttribute("customerId", c.getId());
// 			session.setAttribute("customer", c);
// 			  return "index";
// 			}
 			
	    //登录 
	    public void login() throws IOException{
	        HttpServletResponse resp = ServletActionContext.getResponse();
	        resp.setContentType("application/json;charset=UTF-8");
	        PrintWriter out = null;
	        JSONObject json  = new JSONObject();
	        Customer c1 =customerService.getByUserName(customer);
	    	Customer c =customerService.login(customer);
	    	if(c1==null){
	    		 json.put("result", 3); //该用户不存在
	    	}else{
			   if(c!=null){
		        	 json.put("result", 1); //登录成功
		        	 HttpSession session =ServletActionContext.getRequest().getSession();
		  			session.setAttribute("customerName", c.getCustomerName());
		  			session.setAttribute("customerId", c.getId());
		  			session.setAttribute("customer", c);
		        }else{
		        	json.put("result",2);//密码错误
		        }
	    	}
	         out = resp.getWriter();
	         out.write(json.toString());
			
	    }
	    
	    
 		}
   
   
   
   
	

