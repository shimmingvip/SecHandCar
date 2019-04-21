package com.neusoft.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neusoft.model.Bid;
import com.neusoft.model.Car;
import com.neusoft.model.CarCategory;
import com.neusoft.model.Customer;
import com.neusoft.service.BidService;
import com.neusoft.service.CarCategoryService;
import com.neusoft.service.CarService;
import com.neusoft.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("bidAction")
@Scope("prototype")
public class BidAction extends ActionSupport implements ModelDriven<Bid>{

   private Bid bid;
   
   
   @Override
   public Bid getModel() {
       if(bid==null) bid = new Bid();
     return bid;
   }
   
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
   private BidService bidService;
    
    @Autowired
    private CarCategoryService carCategoryService;
    
    @Autowired
    private CarService  carService;
    
		/**
		 * 进入首页
		 * @Description (TODO这里用一句话描述这个方法的作用)
		 * @return
		 */
    	public String index(){
    	    Pager<Car>  pagers=carService.findPager2(keyword,carPrice);
    	    ActionContext.getContext().put("pagers", pagers);
    	    String hql="from CarCategory where 1=1";
            List<CarCategory> carCatList=carCategoryService.getByHQL(hql, null);
            ActionContext.getContext().put("carCatList", carCatList); 
            ActionContext.getContext().put("keyword2", keyword); 
            return SUCCESS;
    	    
    	}
	
    	/**
    	 * 前台提交竞价信息
    	 * @Description (TODO这里用一句话描述这个方法的作用)
    	 * @return
    	 * @throws IOException 
    	 */
    	public void bid() throws IOException{
    		   Car  c=carService.getById(carId);
    	       HttpServletResponse resp = ServletActionContext.getResponse();
               resp.setContentType("application/json;charset=UTF-8");
               PrintWriter out = null;
                JSONObject json  = new JSONObject();
                 bid.setBidMoney(bid.getBidMoney());
                 bid.setBidTime(bid.getBidTime());
                 bid.setCar(c);
                 Customer existUser = (Customer) ServletActionContext.getRequest().getSession()
         				.getAttribute("customer");
                 bid.setCustomer(existUser);
                 Integer userId=null;
                 List<Bid> bidList=null;
                 if(existUser!=null){
                	   userId=existUser.getId();
                	   String hql="from Bid b where 1=1  and b.customer.id = :userId and b.car.id =:carId";
          			 Map<String,Object> alias = new HashMap<String,Object>();
          			 alias.put("userId", userId);
          			 alias.put("carId", carId);
            		  bidList=bidService.getByHQL(hql, alias);
                 }
                  if(existUser!=null){
                	  if(bidList.size()>0){
                		  json.put("result", 4); //此人已经竞价过此车
                	  }else{
                		  if(Integer.parseInt(c.getCarPrice())<= Integer.parseInt(bid.getBidMoney())){
                   		     bidService.save(bid);
                   		     //更新车的价格
                   		     c.setCarPrice(bid.getBidMoney());
                   		     carService.update(c);
                   		    json.put("result", 1);
                   	  }else{
                   		  json.put("result", 2);
                   	     }
                	  }
                  }else{
                	  json.put("result", 3);
                  } 
                out = resp.getWriter();
                out.write(json.toString());
            }
    	
    	/**
    	 * 我的审核信息
    	 * @return
    	 */
    	public String myInfo() {
  		 Customer existUser = (Customer) ServletActionContext.getRequest().getSession()
    				.getAttribute("customer");
  		 Integer userId=existUser.getId();
  		   Pager<Bid>  pagers=bidService.findPager1(userId);
  		   ActionContext.getContext().put("pagers", pagers); 
		   return SUCCESS;
  	}    
    	
    	
}
