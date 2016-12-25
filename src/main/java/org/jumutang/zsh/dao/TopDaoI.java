package org.jumutang.zsh.dao;

import java.util.List;
import java.util.Map;

import org.jumutang.zsh.model.TopModel;

/**
 * ������dao�ӿ�
 * 
 * @author ³��
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public interface TopDaoI {
	
	/**
	 * ��ѯ������Ϣ
	 * @return list
	 */
	public List<TopModel> queryAll(Short status);
	
	/**
	 * ��ѯ������Ϣ
	 * @param param
	 * @return list
	 */
	public List<TopModel> queryTopByType(Map<String,Object> param);
	
	/**
	 * ��������������Ϣ
	 * 
	 * @param list
	 * @return int
	 */
	public int batchInsertTop(List<TopModel> list);
	
	/**
	 * ��������
	 * 
	 * @param param
	 * 
	 * @return int
	 */
	public int updateTop(Map<String,Object> param);
}
