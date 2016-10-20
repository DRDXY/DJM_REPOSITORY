package com.raze.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: TUserGroup.java
 * @Description: 用户组类
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
public class TUserGroup implements Serializable {

	private static final long serialVersionUID = -441920752544742884L;
	
	private Integer id;
    
    private String groupName;
    
    private Date createTime;
     
    private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
		return "TUserGroup [id=" + id + ", groupName=" + groupName
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}

}
