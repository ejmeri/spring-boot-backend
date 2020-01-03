package com.curse.business.clientes.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.curse.business.addresses.entity.Address;
import com.curse.business.clientes.dto.ClientDTO;
import com.curse.business.clientes.enums.ClientType;
import com.curse.business.orders.entity.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(unique = true) // Chave candidata
	private String email;

	private String document;
	private Integer type;

	// REFERENCIA CICLICA
	@OneToMany(mappedBy = "client", cascade =  CascadeType.ALL)
	private List<Address> addresses = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "telephone")
	private Set<String> telephones = new HashSet<>();

	@JsonIgnore // n serializar os pedidos de um cliente
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();

	public Client() {
	}

	public Client(Integer id, String name, String email, String document, ClientType type) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.document = document;
		this.type = type == null ? null :  type.getCode();
	}

	public Client(ClientDTO clientDto) {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public ClientType getClientType() {
		return ClientType.toEnum(type);
	}

	public void setClientType(ClientType clientType) {
		this.type = clientType.getCode();
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<String> getTelephones() {
		return telephones;
	}

	public void setTelephones(Set<String> telephones) {
		this.telephones = telephones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
