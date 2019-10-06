package com.curse.domain;

import javax.persistence.Entity;

import com.curse.domain.enums.StatusPayment;

@Entity()
public class CardPayment extends Payment {
	private static final long serialVersionUID = 1L;

	private Integer parcels;

	public CardPayment() {
	}

	public CardPayment(Integer id, StatusPayment status, Order order, Integer parcels) {
		super(id, status, order);
		this.parcels = parcels;
	}

	public Integer getParcels() {
		return parcels;
	}

	public void setParcels(Integer parcels) {
		this.parcels = parcels;
	}	
}