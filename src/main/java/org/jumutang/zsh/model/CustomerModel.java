package org.jumutang.zsh.model;

import java.io.Serializable;

/**
 * 客户实体类
 * 
 * @author 鲁雨
 * @since20161225
 * @version v1.0
 * 
 * copyright Luyu(18994139782@163.com)
 *
 */
public class CustomerModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String customerId;
	private String customerName;
	private Integer customerIntegral;
	private String customerHead;
	private Short customerStatus;
	private String customerOpenId;
	private String phone;
	//1。普通用户  2.金牌用户
	private Short customerType;
	private String customerAddress;
	
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getCustomerIntegral() {
		return customerIntegral;
	}
	public void setCustomerIntegral(Integer customerIntegral) {
		this.customerIntegral = customerIntegral;
	}
	public String getCustomerHead() {
		return customerHead;
	}
	public void setCustomerHead(String customerHead) {
		this.customerHead = customerHead;
	}
	public Short getCustomerStatus() {
		return customerStatus;
	}
	public void setCustomerStatus(Short customerStatus) {
		this.customerStatus = customerStatus;
	}
	public String getCustomerOpenId() {
		return customerOpenId;
	}
	public void setCustomerOpenId(String customerOpenId) {
		this.customerOpenId = customerOpenId;
	}
	public Short getCustomerType() {
		return customerType;
	}
	public void setCustomerType(Short customerType) {
		this.customerType = customerType;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
