package com.ejmeri.cursosmc.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ejmeri.cursosmc.domain.enums.StatusPayment;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class BillPayment extends Payment {
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dueDate;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
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