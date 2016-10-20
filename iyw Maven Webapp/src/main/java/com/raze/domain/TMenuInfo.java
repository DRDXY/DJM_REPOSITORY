package com.raze.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: TMenuInfo.java
 * @Description: 菜单类
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
public class TMenuInfo implements Serializable {
	
	private static final long serialVersionUID = -4737720588376585879L;

	private Integer id;
    
    private String menuName;
    
    private String menuUrl;
    
    private String parentId;
    
    private Date createTime;
     
    private Date updateTime;
    
    private String comm;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
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

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	@Override
	public String toString() {
		return "TMenuInfo [id=" + id + ", menuName=" + menuName + ", menuUrl="
				+ menuUrl + ", parentId=" + parentId + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", comm=" + comm
				+ "]";
	}

}
