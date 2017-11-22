package com.feicuiedu.store.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 用户类
 * @author 陈严 创建时间:2017年11月21日
 */
public class User implements Serializable{

	private static final long serialVersionUID = -8045678271382295708L;

	private String id;
	private String name;
	
	private String createById;
	private Date createTime;
	private String lastUpdateById;
	
	public User(String id, String name, String createById, Date createTime, String lastUpdateById, Date lastUpdate) {
		super();
		this.id = id;
		this.name = name;
		this.createById = createById;
		this.createTime = createTime;
		this.lastUpdateById = lastUpdateById;
		this.lastUpdate = lastUpdate;
	}
	
	public User(String name, String createById, Date createTime, String lastUpdateById, Date lastUpdate) {
		super();
		
		this.name = name;
		this.createById = createById;
		this.createTime = createTime;
		this.lastUpdateById = lastUpdateById;
		this.lastUpdate = lastUpdate;
	}
	
	
	public User() {
		super();
	}


	private Date lastUpdate;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreateById() {
		return createById;
	}
	public void setCreateById(String createById) {
		this.createById = createById;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getLastUpdateById() {
		return lastUpdateById;
	}
	public void setLastUpdateById(String lastUpdateById) {
		this.lastUpdateById = lastUpdateById;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
