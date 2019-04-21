package com.neusoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_customer")
public class Customer{
    private int id;
    private String customerName;//客户名
    private String phone;//手机号
    private String passWord;//密码
    private String loginName;//登录名
    private int  isDelete; //0:不删除 1：删除
//    private int sex; //性别 1：男 2：女
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    

	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public int getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}


//	public int getSex() {
//		return sex;
//	}
//
//
//	public void setSex(int sex) {
//		this.sex = sex;
//	}

    
   
}