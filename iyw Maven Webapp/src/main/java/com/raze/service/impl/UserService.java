package com.raze.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.raze.dao.IUserDao;
import com.raze.domain.UserInfo;
import com.raze.service.IUserService;

/**
 * Copyright: Copyright (c) 2016 DJM
 * 
 * @ClassName: UserService.java
 * @Description: 用户Service层实现类
 *
 * @version: v1.0.0
 * @author: DJM
 * @date: 2016-09-18 下午15:25:17
 */
@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;

//	//暂未用到
//	@Override
//	public UserInfo findUserByUserName(String userName) {
//		return userDao.findUserByUserName(userName);
//	}
//
//	//暂未用到
//	@Override
//	public void inserSsq(SsqInfo ssq) {
//		userDao.insert(ssq);
//	}
//
//	//暂未用到
//	@Override
//	public List<SsqInfo> obtainAllRecord(Map<String, Object> parameters) {
//		return userDao.obtainList(parameters);
//	}

	@Override
	public Collection<SimpleGrantedAuthority> obtainAuthorityCollentionByUserName(
			String username) {
		Collection<SimpleGrantedAuthority> collection = new ArrayList<SimpleGrantedAuthority>();
		List<Map<String, Object>> authorityList = userDao.obtainAuthorityCollentionByUserName(username);
		if(authorityList!=null&&authorityList.size()>0){
			for (Map<String, Object> map : authorityList) {
				if(map.get("ROLENAME")==null||map.get("ROLENAME").toString().isEmpty()){
					continue;
				}
				String roleName = map.get("ROLENAME").toString();
				collection.add(new SimpleGrantedAuthority(roleName));
			}
		}
		return collection;
	}

	@Override
	public UserInfo obtainUserInfoByUserName(String username) {
		return userDao.obtainUserInfoByUserName(username);
	}

	@Override
	public Collection<Map<String, Object>> obtainAllAuthority() {
		return userDao.obtainAllAuthority();
	}

}
