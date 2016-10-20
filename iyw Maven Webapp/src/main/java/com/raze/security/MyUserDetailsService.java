package com.raze.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.raze.domain.UserInfo;
import com.raze.service.IUserService;

/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: MyUserDetailService.java
 * @Description: 实现用户查询服务,用于用户验证信息
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUserService  userService;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserInfo userDetailsImpl = userService.obtainUserInfoByUserName(username);
		if(userDetailsImpl!=null){
			Collection<? extends GrantedAuthority> collection = userService.obtainAuthorityCollentionByUserName(username);
			userDetailsImpl.setCollection(collection);
		}
		return userDetailsImpl;
	}

}
