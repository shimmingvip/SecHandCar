package com.neusoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_car")
public class Car{
    private int id;
    private CarCategory carCategory;//车型
    private String carOilConsumption;//油耗
    private String carDisplacement;//排量
    private String carName;//汽车名称
    private String carPrice;//价格
    private String carColr;//颜色
    private String carImage;//图片
    private int  isDelete; //0:不删除 1：删除
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }   

    
    public void setId(int id) {
        this.id = id;
    }

    

    @ManyToOne
    @JoinColumn(name="car_category_id")
    public CarCategory getCarCategory() {
        return carCategory;
    }


    
    public void setCarCategory(CarCategory carCategory) {
        this.carCategory = carCategory;
    }


    public String getCarOilConsumption() {
        return carOilConsumption;
    }
    
    public void setCarOilConsumption(String carOilConsumption) {
        this.carOilConsumption = carOilConsumption;
    }
    
    public String getCarDisplacement() {
        return carDisplacement;
    }
    
    public void setCarDisplacement(String carDisplacement) {
        this.carDisplacement = carDisplacement;
    }


    
  


    
    
    public String getCarPrice() {
		return carPrice;
	}


	public void setCarPrice(String carPrice) {
		this.carPrice = carPrice;
	}


	public String getCarColr() {
        return carColr;
    }


    
    public void setCarColr(String carColr) {
        this.carColr = carColr;
    }


    public String getCarImage() {
        return carImage;
    }


    
    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }


	public int getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}


	public String getCarName() {
		return carName;
	}


	public void setCarName(String carName) {
		this.carName = carName;
	}



    
  
    
  
   
}