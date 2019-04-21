package com.neusoft.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.neusoft.model.Car;
import com.neusoft.model.CarCategory;
import com.neusoft.model.CarCustomer;
import com.neusoft.service.CarCategoryService;
import com.neusoft.service.CarCustomerService;
import com.neusoft.service.CarService;
import com.neusoft.utils.Pager;
import com.neusoft.utils.UUIDUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("carAction")
@Scope("prototype")
public class CarAction extends ActionSupport implements ModelDriven<Car>{

   private Car car;

   @Override
   public Car getModel() {
       if(car==null) car = new Car();
     return car;
   }
    @Autowired
    private CarService carService;
     
    @Autowired
    private CarCategoryService carCategoryService;
    
    @Autowired
    private CarCustomerService carCustomerService;
    
  //========================图片上传
    private File file;
    
    //提交过来的file的名字
    private String fileFileName;
    
    //提交过来的file的MIME类型
    private String fileContentType;

    
    public File getFile() {
        return file;
    }
    public void setFile(File file) {
        this.file = file;
    }
    public String getFileFileName() {
        return fileFileName;
    }
    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
    public String getFileContentType() {
        return fileContentType;
    }
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
    //========================图片上传
    
	     /**
		 * 列表
		 */
		public String car(){
		Pager<Car> pagers = carService.findPager(car);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("car", car);
		return SUCCESS;
		}
		
		
		/**
		 * 跳转到添加页面
		 * @return
		 */
		public String add(){
		    String hql="from CarCategory where 1=1";
		    List<CarCategory> carCatList=carCategoryService.getByHQL(hql, null);
		    ActionContext.getContext().put("carCatList", carCatList);
			return SUCCESS;
		}
		
		/**
		 * 执行添加
		 * @return
		 * @throws Exception 
		 */
		public String exAdd() throws Exception{
		    //图片上传
	        String root  = "D:/my/upload";
	        InputStream is = new FileInputStream(file);
	        fileFileName = UUIDUtils.create()+fileFileName;
	        OutputStream os = new FileOutputStream(new File(root, fileFileName));
	        System.out.println("fileFileName: " + fileFileName);
	        System.out.println("file: " + file.getName());
	        System.out.println("file: " + file.getPath());
	        byte[] buffer = new byte[500];
	        int length = 0;
	        while(-1 != (length = is.read(buffer, 0, buffer.length)))
	        {
	            os.write(buffer);
	        }
	        os.close();
	        is.close();
	        car.setCarImage("\\upload\\"+fileFileName);
	        carService.save(car);
	        //向车型表添加车数量
	        CarCategory carCategory=carCategoryService.getById(car.getCarCategory().getId());
	        carCategory.setNumber(carCategory.getNumber()+1);
	        carCategoryService.update(carCategory);
	        ActionContext.getContext().put("url", "/car_car.do");
            return "redirect";
		    
		}
		
		/**
		 * 跳转修改页面
		 * @return
		 */
		public String update(){
		    Car ad = carService.getById(car.getId());
			ActionContext.getContext().put("car", ad);
			 String hql="from CarCategory where 1=1";
            List<CarCategory> carCatList=carCategoryService.getByHQL(hql, null);
            ActionContext.getContext().put("carCatList", carCatList);
			return SUCCESS;
		}
	    
		/**
		 * 执行修改
		 * @return
		 * @throws Exception 
		 */
		public String exUpdate() throws Exception{
		     Car  c =carService.getById(car.getId());
		    if(file!=null){
		    //图片上传
            String root  = "D:/my/upload";
            InputStream is = new FileInputStream(file);
            fileFileName = UUIDUtils.create()+fileFileName;
            OutputStream os = new FileOutputStream(new File(root, fileFileName));
            System.out.println("fileFileName: " + fileFileName);
            System.out.println("file: " + file.getName());
            System.out.println("file: " + file.getPath());
            byte[] buffer = new byte[500];
            int length = 0;
            while(-1 != (length = is.read(buffer, 0, buffer.length)))
            {
                os.write(buffer);
            }
            os.close();
            is.close();
            c.setCarImage("\\upload\\"+fileFileName);
		    }else{
	            c.setCarImage(c.getCarImage());
		    }
		    c.setCarName(car.getCarName());
		    c.setCarPrice(car.getCarPrice());
		    c.setCarCategory(car.getCarCategory());
		    c.setCarColr(car.getCarColr());
		    c.setCarDisplacement(car.getCarDisplacement());
		    c.setCarOilConsumption(car.getCarOilConsumption());
            carService.update(c);
            ActionContext.getContext().put("url", "/car_car.do");
            return "redirect";
		}
		
		
		/**
		 * 删除
		 * @return
		 */
		public String delete(){
		    //删除车辆信息
			Car c = carService.getById(car.getId());
			 Integer id=car.getId();
			 String hql="from CarCustomer c where 1=1  and c.car.id = :id and  c.car.isDelete=0";
			 Map<String,Object> alias = new HashMap<String,Object>();
			 alias.put("id", id);
			 List<CarCustomer> carCustomerList=carCustomerService.getByHQL(hql, alias);
			for (CarCustomer carCustomer : carCustomerList) {
				carCustomerService.delete(carCustomer.getId());
			}
			c.setIsDelete(1);
			carService.update(c);
			 //向车型表减少车数量
            CarCategory carCategory=carCategoryService.getById(c.getCarCategory().getId());
            carCategory.setNumber(carCategory.getNumber()-1);
            carCategoryService.update(carCategory);
			ActionContext.getContext().put("url", "/car_car.do");
			return "redirect";
		}
	
	
	
	

}
