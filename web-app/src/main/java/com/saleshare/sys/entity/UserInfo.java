package com.saleshare.sys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.saleshare.common.entity.BasicEntity;

@Entity
@Table(name="sys_user")
public class UserInfo extends BasicEntity {

	//正常
	public static final int USER_STATUS_NORMAL= 1;
	//已删除
	public static final int USER_STATUS_DELETED= 2;
	
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name = "user_status")
	private int userStatus=1;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	} 

}
