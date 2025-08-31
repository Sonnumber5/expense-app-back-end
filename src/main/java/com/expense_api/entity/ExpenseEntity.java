package com.expense_api.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "expenses")
public class ExpenseEntity {
	@Id
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "amount")
	private BigDecimal amount; 
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "description")
	private String description;
	
	public ExpenseEntity() {}
	
	public ExpenseEntity(int id, String title, BigDecimal amount, LocalDate date, String description) {
		this.id = id;
		this.title = title;
		this.amount = amount;
		this.date = date;
		this.description = description;
	}
	
	public ExpenseEntity(String title, BigDecimal amount, LocalDate date, String description) {
		this.title = title;
		this.amount = amount;
		this.date = date;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
