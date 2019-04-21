package com.neusoft.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.neusoft.model.Car;
import com.neusoft.model.CarCategory;
import com.neusoft.service.CarCategoryService;
import com.neusoft.service.CarService;
import com.neusoft.utils.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller("carCategoryAction")
@Scope("prototype")
public class CarCategoryAction extends ActionSupport implements ModelDriven<CarCategory>{

   private CarCategory carCategory;

   @Override
   public CarCategory getModel() {
       if(carCategory==null) carCategory = new CarCategory();
     return carCategory;
   }
 
   @Autowired
   private CarCategoryService carCategoryService;
   
   @Autowired
   private CarService carService;
        /**
		 * 列表
		 */
		public String carCategory(){
		Pager<CarCategory> pagers = carCategoryService.findPager(carCategory);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("carCategory", carCategory);
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
			carCategoryService.save(carCategory);
			ActionContext.getContext().put("url", "/carCategory_carCategory.do");
			return "redirect";
		}
		
		/**
		 * 跳转修改页面
		 * @return
		 */
		public String update(){
			CarCategory c = carCategoryService.getById(carCategory.getId());
			ActionContext.getContext().put("carCategory", c);
			return SUCCESS;
		}
	    
		/**
		 * 执行修改
		 * @return
		 */
		public String exUpdate(){
			carCategoryService.update(carCategory);
			ActionContext.getContext().put("url", "/carCategory_carCategory.do");
			return "redirect";
		}
		
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
			CarCategory c = carCategoryService.getById(carCategory.getId());
			Integer id=carCategory.getId();
			 String hql="from Car c where 1=1  and c.carCategory.id = :id and  c.carCategory.isDelete=0";
			 Map<String,Object> alias = new HashMap<String,Object>();
			 alias.put("id", id);
			 List<Car> carList=carService.getByHQL(hql, alias);
			 for (Car car : carList) {
				 car.setIsDelete(1);
				 carService.update(car);
			}
			c.setIsDelete(1);
			carCategoryService.update(c);
			ActionContext.getContext().put("url", "/carCategory_carCategory.do");
			return "redirect";
		}
	
   
	

}
