package org.jumutang.zsh.services;

import org.jumutang.zsh.model.CustomerModel;

/**
 * �ͻ��ķ����
 * 
 * @author ³��
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public interface CustomerServiceI {

	/**
	 * ��ѯ�����û�
	 * 
	 * @param openId
	 * @return CustomerModel
	 */
	public CustomerModel queryByOpenId(String openId);
}
