package com.order.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.BaseCondition;
import com.user.bean.Org;
import com.util.EmptyUtil;

/**
 * Description:   订单查询条件类
 * @author: 杨聪艺
 * Create Date: 2014-8-15
 * <pre>
 * 修改记录:
 * 修改后版本			修改人		修改日期			修改内容 
 * 2014-8-15.1		杨聪艺		2014-8-15		create					
 * </pre>
 */
public class OrderQueryCondition extends BaseCondition implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1289396252389607844L;
	
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
	private Date expiryDateFm;
	private Date expiryDateTo;
	private String haveChild;
	private Date timeExpand;
	private String status;
	private String isInCar;
	private String isPreOrder;
	private Date preTimeFm;
	private Date preTimeTo;
	private String remark;
	private Date createTimeFm;
	private Date createTimeTo;
	
	public Map<String,Object> toMapCondition() {
		Map<String,Object> condition = new HashMap<String, Object>();
		if(EmptyUtil.isNotEmpty(id)) {
			condition.put("id", id);
		}
		if(EmptyUtil.isNotEmpty(org) && EmptyUtil.isNotEmpty(org.getId())) {
			condition.put("orgId", org.getId());
		}
		if(EmptyUtil.isNotEmpty(userPhone)) {
			condition.put("userPhone", userPhone);
		}
		if(EmptyUtil.isNotEmpty(passengerPhone)) {
			condition.put("passengerPhone", passengerPhone);
		}
		if(EmptyUtil.isNotEmpty(startPlace)) {
			condition.put("startPlace", startPlace);
		}
		if(EmptyUtil.isNotEmpty(endPlace)) {
			condition.put("endPlace", endPlace);
		}
		if(EmptyUtil.isNotEmpty(personNumber)) {
			condition.put("personNumber", personNumber);
		}
		if(EmptyUtil.isNotEmpty(isWholeCar)) {
			condition.put("isWholeCar", isWholeCar);
		}
		if(EmptyUtil.isNotEmpty(expiryDateFm)) {
			condition.put("expiryDateFm", expiryDateFm);
		}
		if(EmptyUtil.isNotEmpty(expiryDateTo)) {
			condition.put("expiryDateTo", expiryDateTo);
		}
		if(EmptyUtil.isNotEmpty(haveChild)) {
			condition.put("haveChild", haveChild);
		}
		if(EmptyUtil.isNotEmpty(status)) {
			condition.put("status", status);
		}
		if(EmptyUtil.isNotEmpty(isPreOrder)) {
			condition.put("isPreOrder", isPreOrder);
		}
		if(EmptyUtil.isNotEmpty(preTimeFm)) {
			condition.put("preTimeFm", preTimeFm);
		}
		if(EmptyUtil.isNotEmpty(preTimeTo)) {
			condition.put("preTimeTo", preTimeTo);
		}
		if(EmptyUtil.isNotEmpty(remark)) {
			condition.put("remark", remark);
		}
		if(EmptyUtil.isNotEmpty(createTimeFm)) {
			condition.put("createTimeFm", createTimeFm);
		}
		if(EmptyUtil.isNotEmpty(createTimeTo)) {
			condition.put("createTimeTo", createTimeTo);
		}
		return condition;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getPassengerPhone() {
		return passengerPhone;
	}
	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	public String getStartPlacePoint() {
		return startPlacePoint;
	}
	public void setStartPlacePoint(String startPlacePoint) {
		this.startPlacePoint = startPlacePoint;
	}
	public String getEndPlace() {
		return endPlace;
	}
	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}
	public String getEndPlacePoint() {
		return endPlacePoint;
	}
	public void setEndPlacePoint(String endPlacePoint) {
		this.endPlacePoint = endPlacePoint;
	}
	public Integer getPersonNumber() {
		return personNumber;
	}
	public void setPersonNumber(Integer personNumber) {
		this.personNumber = personNumber;
	}
	public String getIsWholeCar() {
		return isWholeCar;
	}
	public void setIsWholeCar(String isWholeCar) {
		this.isWholeCar = isWholeCar;
	}
	public Date getExpiryDateFm() {
		return expiryDateFm;
	}
	public void setExpiryDateFm(Date expiryDateFm) {
		this.expiryDateFm = expiryDateFm;
	}
	public Date getExpiryDateTo() {
		return expiryDateTo;
	}
	public void setExpiryDateTo(Date expiryDateTo) {
		this.expiryDateTo = expiryDateTo;
	}
	public String getHaveChild() {
		return haveChild;
	}
	public void setHaveChild(String haveChild) {
		this.haveChild = haveChild;
	}
	public Date getTimeExpand() {
		return timeExpand;
	}
	public void setTimeExpand(Date timeExpand) {
		this.timeExpand = timeExpand;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsInCar() {
		return isInCar;
	}
	public void setIsInCar(String isInCar) {
		this.isInCar = isInCar;
	}
	public String getIsPreOrder() {
		return isPreOrder;
	}
	public void setIsPreOrder(String isPreOrder) {
		this.isPreOrder = isPreOrder;
	}
	public Date getPreTimeFm() {
		return preTimeFm;
	}
	public void setPreTimeFm(Date preTimeFm) {
		this.preTimeFm = preTimeFm;
	}
	public Date getPreTimeTo() {
		return preTimeTo;
	}
	public void setPreTimeTo(Date preTimeTo) {
		this.preTimeTo = preTimeTo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateTimeFm() {
		return createTimeFm;
	}
	public void setCreateTimeFm(Date createTimeFm) {
		this.createTimeFm = createTimeFm;
	}
	public Date getCreateTimeTo() {
		return createTimeTo;
	}
	public void setCreateTimeTo(Date createTimeTo) {
		this.createTimeTo = createTimeTo;
	}

}
