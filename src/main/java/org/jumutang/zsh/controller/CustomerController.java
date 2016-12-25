package org.jumutang.zsh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jumutang.zsh.model.CustomerModel;
import org.jumutang.zsh.services.CustomerServiceI;
import org.jumutang.zsh.tools.ResResult;
import org.jumutang.zsh.tools.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 表格
 * 
 * @author 鲁雨
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerServiceI customerService;
	/**
	 * 获取单个用户信息
	 * 
	 * @param request
	 * @return resResult
	 */
	@ResponseBody
	@RequestMapping("/query")
	public ResResult queryByOpenId(HttpServletRequest request){
		HttpSession session = request.getSession();
		String openId = (String)session.getAttribute("openId");
		if(openId==null){
			return ResponseModel.errorActive("请先登录");
		}
		
		CustomerModel customerModel = customerService.queryByOpenId(openId);
		if(customerModel==null){
			return ResponseModel.errorActive("用户不存在");
		}
		return ResponseModel.returnDate(customerModel);
	}
}
