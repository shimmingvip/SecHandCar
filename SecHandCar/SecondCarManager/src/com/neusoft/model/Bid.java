package com.neusoft.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_bid")
public class Bid {
	private int id;
	private Customer customer;//与客户表关联
	private Car car;//汽车关联
	private String bidTime; //竞价时间
    private String bidMoney; //竞价价格
    private int state;//是否审核 0：未审核 1：审核通过
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
    @JoinColumn(name="car_id")
    public Car getCar() {
        return car;
    }

    
    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    @JoinColumn(name="customer_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getBidTime() {
		return bidTime;
	}

	public void setBidTime(String bidTime) {
		this.bidTime = bidTime;
	}

	
	public String getBidMoney() {
		return bidMoney;
	}

	public void setBidMoney(String bidMoney) {
		this.bidMoney = bidMoney;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

    
  

}
