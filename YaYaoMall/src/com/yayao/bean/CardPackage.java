package com.yayao.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 卡卷包
 * @author yy
 *
 */
@Entity
@Table(name="card_package_tb",catalog="yayaomall_db")
public class CardPackage implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 卡卷包id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cardPackageId;
	/**
	 * 类型（卡，卷，包）
	 */
	private String cpType;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 抵消金额
	 */
	private Double offsetAmount;
	/**
	 *账户
	 */
	@ManyToOne(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	@JsonManagedReference
	private User user;
	
	
	public CardPackage() {
		super();
	}

	
	public CardPackage(Integer cardPackageId, String cpType, Date startTime,
			Date endTime, Double offsetAmount, User user) {
		super();
		this.cardPackageId = cardPackageId;
		this.cpType = cpType;
		this.startTime = startTime;
		this.endTime = endTime;
		this.offsetAmount = offsetAmount;
		this.user = user;
	}


	public Integer getCardPackageId() {
		return cardPackageId;
	}

	public void setCardPackageId(Integer cardPackageId) {
		this.cardPackageId = cardPackageId;
	}

	public String getCpType() {
		return cpType;
	}

	public void setCpType(String cpType) {
		this.cpType = cpType;
	}

	public Double getOffsetAmount() {
		return offsetAmount;
	}

	public void setOffsetAmount(Double offsetAmount) {
		this.offsetAmount = offsetAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	
}
