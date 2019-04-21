package com.neusoft.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.neusoft.model.Order;
import com.neusoft.service.OrderService;
import com.neusoft.utils.Pager;

@Controller("orderAction")
@Scope("prototype")
public class OrderAction extends ActionSupport implements ModelDriven<Order>{

   private Order order;
   

@Override
   public Order getModel() {
       if(order==null) order = new Order();
     return order;
   }
    @Autowired
   private OrderService orderService;
    
    
	     /**
		 * 列表
		 */
		public String order(){
		Pager<Order> pagers = orderService.findPager(order);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("order", order);
		return SUCCESS;
		}
		
		
	    
		/**
		 * 执行修改(审核)
		 * @return
		 */
		public String confirm(){
		    Order o=orderService.getById(order.getId());
			o.setState(1);
			orderService.update(o);
			ActionContext.getContext().put("url", "/order_order.do");
			return "redirect";
		}
		
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
		    Order o=orderService.getById(order.getId());
		    o.setIsDelete(1);
			orderService.update(o);
			ActionContext.getContext().put("url", "/order_order.do");
			return "redirect";
		}
	
		 /**
		 * 审核通过列表
		 */
		public String orderPass(){
		Pager<Order> pagers = orderService.findPager1(order);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("order", order);
		return SUCCESS;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
