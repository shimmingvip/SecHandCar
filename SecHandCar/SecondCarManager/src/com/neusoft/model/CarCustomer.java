package com.neusoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_car_customer")
public class CarCustomer{
    private int id; 
    private Customer customer; //与客户表关联
    private Car car; //与汽车表关联
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
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
    


  
   
}