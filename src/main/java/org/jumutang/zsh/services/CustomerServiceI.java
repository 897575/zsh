package org.jumutang.zsh.services;

import org.jumutang.zsh.model.CustomerModel;

/**
 * 客户的服务层
 * 
 * @author 鲁雨
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public interface CustomerServiceI {

	/**
	 * 查询单个用户
	 * 
	 * @param openId
	 * @return CustomerModel
	 */
	public CustomerModel queryByOpenId(String openId);
}
