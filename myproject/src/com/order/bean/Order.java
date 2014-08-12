package com.order.bean;

import java.util.Date;

import com.user.bean.Org;

/**
 * AbstractOrders entity provides the base persistence definition of the Orders
 * entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -505509538232098500L;
	private Integer id;
	private Org org;
	private String userPhone;
	private String passengerPhone;
	private String startPlace;
	private String startPlacePoint;
	private String endPlace;
	private String endPlacePoint;
	private Integer personNumber;
	private String isWholeCar;
	private Date expiryDate;
	private String haveChild;
	private Date timeExpand;
	private String status;
	private String isInCar;
	private String isPreOrder;
	private Date preTime;
	private String remark;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Org org, String userPhone, String passengerPhone,
			String startPlace, String startPlacePoint, String endPlace,
			String endPlacePoint, Integer personNumber, String isWholeCar,
			Date expiryDate, String haveChild, Date timeExpand, String status,
			String isInCar, String isPreOrder, Date preTime, String remark) {
		this.org = org;
		this.userPhone = userPhone;
		this.passengerPhone = passengerPhone;
		this.startPlace = startPlace;
		this.startPlacePoint = startPlacePoint;
		this.endPlace = endPlace;
		this.endPlacePoint = endPlacePoint;
		this.personNumber = personNumber;
		this.isWholeCar = isWholeCar;
		this.expiryDate = expiryDate;
		this.haveChild = haveChild;
		this.timeExpand = timeExpand;
		this.status = status;
		this.isInCar = isInCar;
		this.isPreOrder = isPreOrder;
		this.preTime = preTime;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Org getOrg() {
		return this.org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getPassengerPhone() {
		return this.passengerPhone;
	}

	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}

	public String getStartPlace() {
		return this.startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getStartPlacePoint() {
		return this.startPlacePoint;
	}

	public void setStartPlacePoint(String startPlacePoint) {
		this.startPlacePoint = startPlacePoint;
	}

	public String getEndPlace() {
		return this.endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}

	public String getEndPlacePoint() {
		return this.endPlacePoint;
	}

	public void setEndPlacePoint(String endPlacePoint) {
		this.endPlacePoint = endPlacePoint;
	}

	public Integer getPersonNumber() {
		return this.personNumber;
	}

	public void setPersonNumber(Integer personNumber) {
		this.personNumber = personNumber;
	}

	public String getIsWholeCar() {
		return this.isWholeCar;
	}

	public void setIsWholeCar(String isWholeCar) {
		this.isWholeCar = isWholeCar;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getHaveChild() {
		return this.haveChild;
	}

	public void setHaveChild(String haveChild) {
		this.haveChild = haveChild;
	}

	public Date getTimeExpand() {
		return this.timeExpand;
	}

	public void setTimeExpand(Date timeExpand) {
		this.timeExpand = timeExpand;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsInCar() {
		return this.isInCar;
	}

	public void setIsInCar(String isInCar) {
		this.isInCar = isInCar;
	}

	public String getIsPreOrder() {
		return this.isPreOrder;
	}

	public void setIsPreOrder(String isPreOrder) {
		this.isPreOrder = isPreOrder;
	}

	public Date getPreTime() {
		return this.preTime;
	}

	public void setPreTime(Date preTime) {
		this.preTime = preTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}