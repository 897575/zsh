package org.jumutang.zsh.dao;

import org.jumutang.zsh.model.CustomerModel;

/**
 * �ͻ���dao�ӿ�
 * 
 * @author ³��
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public interface CustomerDaoI {
	/**
	 * ��ѯ�ͻ���Ϣ
	 * @param openId
	 * @return custormerModel
	 */
	public CustomerModel queryByOpenId(String openId);
}
