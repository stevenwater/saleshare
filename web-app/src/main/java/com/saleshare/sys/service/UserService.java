package com.saleshare.sys.service;

import java.sql.Timestamp;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saleshare.common.service.BasicServiceImpl;
import com.saleshare.sys.entity.UserInfo;

@Service
public class UserService extends BasicServiceImpl<UserInfo> {
	
	@Transactional(readOnly = false,rollbackFor = { Exception.class, RuntimeException.class })
	public void generateRandomUser(){
		for(int i = 0; i < 100; i++){
			UserInfo user = new UserInfo();
			user.setCreateTime(new Timestamp(System.currentTimeMillis()));
			user.setUserName(generateRandomName());
			user.setPassword(user.getUserName());
			user.setUserStatus(i%2==0 ? UserInfo.USER_STATUS_NORMAL : UserInfo.USER_STATUS_DELETED);
			getSession().save(user);
			getSession().clear();
		}
	}
	
	private char[] characters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','o','p','q','r','s','t','u','v','w','x','y','z'};
	private String generateRandomName(){
		StringBuilder sb = new StringBuilder();
		int nameLen = Math.abs(new Random().nextInt()%20);
		nameLen = nameLen < 10 ? 10: nameLen;
		int nameChar = 0;
		for(int i = 0; i<nameLen; i++ ){
			nameChar = Math.abs(new Random().nextInt()%25);
			sb.append(characters[nameChar]);
		}
		return sb.toString();
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(readOnly = false,rollbackFor = { Exception.class, RuntimeException.class })
	public void batchDelete(Integer[] ids){
		if(ids!= null && ids.length > 0){
			for(Integer id : ids){
				delete(UserInfo.class, id);
			}
		}
	}
}
