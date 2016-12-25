package org.jumutang.zsh.services;

import java.util.List;

import org.jumutang.zsh.model.OilModel;

/**
 * �͵ķ����
 * 
 * @author ³��
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public interface OilServiceI {
	
	/**
	 * ��ѯ�ͼ�
	 * 
	 * @return list
	 */
	public List<OilModel> queryOil();

	/**
	 * ��������
	 * 
	 * @param list
	 * 
	 * @return int
	 */
	public int batchInsertOil(List<OilModel> list);
	
	/**
	 * �����ͼ�״̬
	 * 
	 * @return int
	 */
	public int updateOil();
}
