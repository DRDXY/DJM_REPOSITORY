package com.raze.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: TFunctionInfo.java
 * @Description: 功能操作类
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
public class TFunctionInfo implements Serializable {
	
	private static final long serialVersionUID = -4737720588376585879L;

	private Integer id;
    
    private String functionName;
    
    private String filterUrl;
    
    private Date createTime;
     
    private Date updateTime;
    
    private String comm;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFilterUrl() {
		return filterUrl;
	}

	public void setFilterUrl(String filterUrl) {
		this.filterUrl = filterUrl;
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
		return "TFunctionInfo [id=" + id + ", functionName=" + functionName
				+ ", filterUrl=" + filterUrl + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", comm=" + comm + "]";
	}

}
