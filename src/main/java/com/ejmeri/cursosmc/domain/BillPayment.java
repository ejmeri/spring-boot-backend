package com.ejmeri.cursosmc.domain;

import java.util.Date;

import com.ejmeri.cursosmc.domain.enums.StatusPayment;

public class BillPayment extends Payment {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Date dueDate;
	private Date paymentDate;

	public BillPayment() {
	}

	public BillPayment(Integer id, StatusPayment status, Order order, Date dueDate, Date paymentDate) {
		super(id, status, order);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	
	
	
}