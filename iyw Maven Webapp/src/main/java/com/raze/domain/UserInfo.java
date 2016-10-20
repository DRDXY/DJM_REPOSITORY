package com.raze.domain;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: UserInfo.java
 * @Description: 用户类
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
public class UserInfo implements UserDetails {

	private static final long serialVersionUID = -39543742025742836L;

	private Integer id;
    
    private String userName;
    
    private String password;
    
    private String telephone;
     
    private Date createTime;
     
    private Date updateTime;
    
    private Integer isEnable;
    
    private Collection<? extends GrantedAuthority> collection;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	
	public Collection<? extends GrantedAuthority> getCollection() {
		return collection;
	}

	public void setCollection(Collection<? extends GrantedAuthority> collection) {
		this.collection = collection;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName + ", password="
				+ password + ", telephone=" + telephone + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", isEnable="
				+ isEnable + ", collection=" + collection + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getCollection();
	}

	@Override
	public String getUsername() {
		return getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
