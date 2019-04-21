package com.neusoft.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_admin")
public class Admin {
	private int id;
	private String adminName;//管理员名
	private String passWord;//密码
	private int sex; //性别 1：男 2：女
	private int  isDelete; //0:不删除 1：删除
	private String phone;///联系电话
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getAdminName() {
        return adminName;
    }
    
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    
    public String getPassWord() {
        return passWord;
    }
    
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
    

}
