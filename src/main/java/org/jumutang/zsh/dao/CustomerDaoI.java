package org.jumutang.zsh.dao;

import org.jumutang.zsh.model.CustomerModel;

/**
 * 客户的dao接口
 * 
 * @author 鲁雨
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public interface CustomerDaoI {
	/**
	 * 查询客户信息
	 * @param openId
	 * @return custormerModel
	 */
	public CustomerModel queryByOpenId(String openId);
}
