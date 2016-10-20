package com.raze.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.raze.domain.UserInfo;


/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: IUserService.java
 * @Description: 用户Service层接口
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
public interface IUserService {

	Collection<SimpleGrantedAuthority> obtainAuthorityCollentionByUserName(
			String username);

	Collection<Map<String, Object>> obtainAllAuthority();

	UserInfo obtainUserInfoByUserName(String username);

//	//暂未用到
//	UserInfo findUserByUserName(String userName);
//
//	//暂未用到
//	void inserSsq(SsqInfo ssq);
//
//	//暂未用到
//	List<SsqInfo> obtainAllRecord(Map<String, Object> parameters);

}
