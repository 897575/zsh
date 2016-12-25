package org.jumutang.zsh.dao;

import java.util.List;
import java.util.Map;

import org.jumutang.zsh.model.OilModel;

/**
 * �͵�dao�ӿ�
 * 
 * @author ³��
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public interface OilDaoI {

	/**
	 * ��ѯ�����ͼ�
	 * 
	 * @param dateTime
	 * 
	 * @return string
	 */
	public List<OilModel> queryOil(Short status);
	
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
	 * @param param
	 * 
	 * @return int
	 */
	public int updateOil(Map<String,Object> param);
}
