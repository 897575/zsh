package org.jumutang.zsh.model;

import java.io.Serializable;

/**
 * �͵�ʵ����
 * 
 * @author ³��
 * @since20161223
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public class OilModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String oilId;
	private String oilDate;
	private Short oilPriceType;
	//��Ʒ������
	private Short oilCategoryType;
	//��Ʒ
	private String oilCategory;
	//��״̬
	private Short oilStatus;
	private String oilPrice;
	//��������
	private Integer desc;
	
	public Integer getDesc() {
		return desc;
	}
	public void setDesc(Integer desc) {
		this.desc = desc;
	}
	public String getOilId() {
		return oilId;
	}
	public void setOilId(String oilId) {
		this.oilId = oilId;
	}
	public String getOilDate() {
		return oilDate;
	}
	public void setOilDate(String oilDate) {
		this.oilDate = oilDate;
	}
	public Short getOilPriceType() {
		return oilPriceType;
	}
	public void setOilPriceType(Short oilPriceType) {
		this.oilPriceType = oilPriceType;
	}
	public Short getOilCategoryType() {
		return oilCategoryType;
	}
	public void setOilCategoryType(Short oilCategoryType) {
		this.oilCategoryType = oilCategoryType;
	}
	public String getOilCategory() {
		return oilCategory;
	}
	public void setOilCategory(String oilCategory) {
		this.oilCategory = oilCategory;
	}
	public Short getOilStatus() {
		return oilStatus;
	}
	public void setOilStatus(Short oilStatus) {
		this.oilStatus = oilStatus;
	}
	public String getOilPrice() {
		return oilPrice;
	}
	public void setOilPrice(String oilPrice) {
		this.oilPrice = oilPrice;
	}
	
}
