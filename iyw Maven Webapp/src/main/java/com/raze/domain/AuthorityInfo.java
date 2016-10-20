package com.raze.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: AuthorityInfo.java
 * @Description: 权限类
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
public class AuthorityInfo implements Serializable {
	
	private static final long serialVersionUID = -4737720588376585879L;

	private Integer id;
    
    private String authorityName;
    
    private String interceptUrl;
    
    private String accessAuth;
    
    private String comm;
    
    private Date createTime;
     
    private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getInterceptUrl() {
		return interceptUrl;
	}

	public void setInterceptUrl(String interceptUrl) {
		this.interceptUrl = interceptUrl;
	}

	public String getAccessAuth() {
		return accessAuth;
	}

	public void setAccessAuth(String accessAuth) {
		this.accessAuth = accessAuth;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
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
		return "AuthorityInfo [id=" + id + ", authorityName=" + authorityName
				+ ", interceptUrl=" + interceptUrl + ", accessAuth="
				+ accessAuth + ", comm=" + comm + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

}
