package com.market.model.transport;

import java.time.LocalDate;

public class ClientDTO {
private Integer id;
	
	private String name;
	
	private String cpf;
	
	private LocalDate bornDate;

	
	public ClientDTO(Integer id, String name, String cpf, LocalDate bornDate) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.bornDate = bornDate;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBornDate() {
		return bornDate;
	}

	public void setBornDate(LocalDate bornDate) {
		this.bornDate = bornDate;
	}
	
	
}
