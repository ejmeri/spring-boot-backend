package com.ejmeri.cursosmc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.ejmeri.cursosmc.domain.enums.StatusPayment;

@Entity
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private StatusPayment status;
	
	@OneToOne
	@JoinColumn(name= "orderId")
	@MapsId // ID DO PAGAMENTO SERA O MESMO DO PEDIDO
	private Order order;

	public Payment() {
	}

	public Payment(Integer id, StatusPayment status, Order order) {
		this.id = id;
		this.setStatus(status);
		this.setOrder(order);
	}
	

	public StatusPayment getStatus() {
		return status;
	}

	public void setStatus(StatusPayment status) {
		this.status = status;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
}