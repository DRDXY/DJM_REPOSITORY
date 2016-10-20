package com.raze.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: RoleInfo.java
 * @Description: 角色类
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
public class RoleInfo implements Serializable {
	
	private static final long serialVersionUID = -4737720588376585879L;

	private Integer id;
    
    private String roleName;
    
    private String describe;
    
    private Date createTime;
     
    private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "RoleInfo [id=" + id + ", roleName=" + roleName + ", describe="
				+ describe + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}

}
