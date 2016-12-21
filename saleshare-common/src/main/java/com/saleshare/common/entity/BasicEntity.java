package com.saleshare.common.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BasicEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique = true, nullable = false)
	private int id;
	
	@Column(name="create_time")
	private Timestamp createTime;
	
	@Column(name = "create_user")
	private int createUser;
	
	@Column(name="last_modify_time")
	private Timestamp lastModifyTime;
	
	@Column(name="last_modify_user")
	private int lastModifyUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getCreateUser() {
		return createUser;
	}

	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}

	public Timestamp getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Timestamp lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public int getLastModifyUser() {
		return lastModifyUser;
	}

	public void setLastModifyUser(int lastModifyUser) {
		this.lastModifyUser = lastModifyUser;
	}

}
