package com.saleshare.sys.controller;

import org.apache.log4j.Logger;
import org.saleshare.common.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saleshare.common.pagination.PaginationQuery;
import com.saleshare.common.pagination.PaginationResult;
import com.saleshare.sys.entity.UserInfo;
import com.saleshare.sys.service.UserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private UserService userService;

	@RequestMapping("show")
	public String show(){
		logger.info("invoking UserAction->show");
		return "sys/user_management";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public JsonResponse delete(@RequestParam Integer[] ids){
		JsonResponse resp = new JsonResponse();
		if(ids == null || ids.length == 0){
			resp.setCode(JsonResponse.FAIL);
		}
		logger.info("ids : " + ids);
		userService.batchDelete(ids);
		resp.setCode(JsonResponse.SUCCESS);
		return resp;
	}
	
	@RequestMapping("randomUsers")
	public String randomUsers(){
		userService.generateRandomUser();
		return "sys/user_management";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public PaginationResult<UserInfo> list(String userName,Integer userStatus,Integer page,Integer rows){
		PaginationQuery query = new PaginationQuery();
		StringBuilder hql = new StringBuilder();
		hql.append("from UserInfo u where 1=1 ");
		if(!StringUtils.isEmpty(userName)){
			query.addParam(userName);
			hql.append("and u.userName = ? ");
		}
		
		if(userStatus != null && userStatus > 0){
			query.addParam(userStatus);
			hql.append("and u.userStatus = ? ");
		}
		query.page = page;
		query.rows = rows;
		
		PaginationResult<UserInfo> pager = userService.queryByPagination(query, hql.toString());
		return pager;
	}
	
}
