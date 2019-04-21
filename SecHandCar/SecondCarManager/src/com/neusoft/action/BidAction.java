package com.neusoft.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neusoft.model.Bid;
import com.neusoft.model.Car;
import com.neusoft.model.CarCategory;
import com.neusoft.model.CarCustomer;
import com.neusoft.model.Customer;
import com.neusoft.model.Order;
import com.neusoft.service.BidService;
import com.neusoft.service.CarCategoryService;
import com.neusoft.service.CarCustomerService;
import com.neusoft.service.CarService;
import com.neusoft.service.CustomerService;
import com.neusoft.service.OrderService;
import com.neusoft.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("bidAction")
@Scope("prototype")
public class BidAction extends ActionSupport implements ModelDriven<Bid>{

   private Bid bid;
   
    private String cName;
    
     
   
   public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}


@Override
   public Bid getModel() {
       if(bid==null) bid = new Bid();
     return bid;
   }
 
   @Autowired
   private BidService bidService;
   
   @Autowired
   private OrderService orderService;
   
   @Autowired
   private CarService carService;
   
   @Autowired
   private CustomerService customerService;
   
   @Autowired
   private CarCustomerService carCustomerService;
   
   @Autowired
   private CarCategoryService carCategoryService;
   /**
 		 * 列表
 		 */
 		public String bid(){
 		Pager<Bid> pagers = bidService.findPager(cName);
 		ActionContext.getContext().put("pagers", pagers);
 		ActionContext.getContext().put("bid", bid);
 		ActionContext.getContext().put("cName", cName);
 		return SUCCESS;
 		}
 		
 		
 	    
 		/**
 		 * 执行修改(审核通过)
 		 * @return
 		 */
 		public String pass(){
 			Bid b = bidService.getById(bid.getId());
 			b.setState(1);
 			bidService.update(b);
 			Car c =carService.getById(b.getCar().getId());
 			Customer cu=customerService.getById(b.getCustomer().getId());
 			Order o =new Order();
 			o.setCar(c);
 			o.setCustomer(cu);
 			 Calendar calendar = Calendar.getInstance();
 			 //订单号
 	        o.setCode(""+calendar.getTime().getTime());
 	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 			o.setCreateTime(dateFormat.format(new Date()));
 			o.setBid(b);
 			orderService.save(o);
 			CarCustomer cc=new CarCustomer();
 			cc.setCar(c);
 			cc.setCustomer(cu);
 			carCustomerService.save(cc);
 			 //向车型表减少车数量
            CarCategory carCategory=carCategoryService.getById(c.getCarCategory().getId());
            carCategory.setNumber(carCategory.getNumber()-1);
            carCategoryService.update(carCategory);
 			ActionContext.getContext().put("url", "/bid_bid.do");
 			return "redirect";
 		}
 		/**
 		 * 执行修改(审核不通过)
 		 * @return
 		 */
 		public String nopass(){
 			Bid b = bidService.getById(bid.getId());
 			b.setState(2);
 			bidService.update(b);
 			ActionContext.getContext().put("url", "/bid_bid.do");
 			return "redirect";
 		}
 		
 		
 		/**
 		 * 删除
 		 * @return
 		 */
 		public String delete(){
 			Bid b = bidService.getById(bid.getId());
 			bidService.update(b);
 			ActionContext.getContext().put("url", "/bid_bid.do");
 			return "redirect";
 		}
 	
   
}
