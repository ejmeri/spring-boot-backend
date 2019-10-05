package com.ejmeri.cursosmc.domain.enums;

public enum StatusPayment {
    PEDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

	private int code;
	private String description;

	private StatusPayment(int code, String description) {
		this.code = code;
		this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static StatusPayment toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (StatusPayment x : StatusPayment.values()) {
			if (code.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + code);
	}
    
    
}