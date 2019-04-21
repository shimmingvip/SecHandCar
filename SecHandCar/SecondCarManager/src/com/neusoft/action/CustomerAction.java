package com.neusoft.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neusoft.model.Admin;
import com.neusoft.model.Customer;
import com.neusoft.service.CustomerService;
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
    
    
	     /**
		 * 列表
		 */
		public String customer(){
		Pager<Customer> pagers = customerService.findPager(customer);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("customer", customer);
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
			customerService.save(customer);
			ActionContext.getContext().put("url", "/customer_customer.do");
			return "redirect";
		}
		
		/**
		 * 跳转修改页面
		 * @return
		 */
		public String update(){
			Customer c = customerService.getById(customer.getId());
			ActionContext.getContext().put("customer", c);
			return SUCCESS;
		}
	    
		/**
		 * 执行修改
		 * @return
		 */
		public String exUpdate(){
			customerService.update(customer);
			ActionContext.getContext().put("url", "/customer_customer.do");
			return "redirect";
		}
		
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			Customer c = customerService.getById(customer.getId());
			c.setIsDelete(1);
			customerService.update(c);
			ActionContext.getContext().put("url", "/customer_customer.do");
			return "redirect";
		}
	
	
	
	
}
