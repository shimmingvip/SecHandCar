package com.neusoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_car_category")
public class CarCategory{
    private int id;
    private String cname;//车型名字
    private int number;//库存
    private int  isDelete; //0:不删除 1：删除
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }


    
    public String getCname() {
        return cname;
    }


    
    public void setCname(String cname) {
        this.cname = cname;
    }


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public int getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}


  

    
  

   
  
   
}