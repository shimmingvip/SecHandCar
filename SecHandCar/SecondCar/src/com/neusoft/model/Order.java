package com.neusoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_order")
public class Order{
    private int id;
    private String code;//订单号
    private Customer customer;//客户
    private Car car;//汽车
    private String createTime;//订单时间
    private int isDelete;//0：不删除 1：删除
    private int state ;//订单状态 0:未审核 1：审核
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getCode() {
        return code;
    }

    
    public void setCode(String code) {
        this.code = code;
    }

    @ManyToOne
    @JoinColumn(name="customer_id")
    public Customer getCustomer() {
        return customer;
    }

    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    @ManyToOne
    @JoinColumn(name="car_id")
    public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getCreateTime() {
        return createTime;
    }

    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    
    public int getIsDelete() {
        return isDelete;
    }

    
    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

  
    
}