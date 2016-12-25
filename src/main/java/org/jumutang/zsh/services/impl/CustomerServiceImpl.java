package org.jumutang.zsh.services.impl;

import org.jumutang.zsh.dao.CustomerDaoI;
import org.jumutang.zsh.model.CustomerModel;
import org.jumutang.zsh.services.CustomerServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerServiceI {
	@Autowired
	private CustomerDaoI customerDaoI;

	/**
	 * ��ѯ�����û�
	 * 
	 * @param openId
	 * @return CustomerModel
	 */
	public CustomerModel queryByOpenId(String openId) {
		
		return customerDaoI.queryByOpenId(openId);
	}

}
