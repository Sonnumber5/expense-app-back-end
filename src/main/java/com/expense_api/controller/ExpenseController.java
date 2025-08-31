package com.expense_api.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense_api.entity.ExpenseEntity;
import com.expense_api.service.ExpenseService;


@RestController
@RequestMapping("/expenses")
@CrossOrigin(origins = "http://localhost:3000")
public class ExpenseController {
	
	private final ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@GetMapping
	public CompletableFuture<List<ExpenseEntity>> getAllExpenses(){
		return expenseService.getAllExpenses();
	}
	
	@GetMapping("/{id}")
	public CompletableFuture<ExpenseEntity> getExpenseById(@PathVariable int id) {
		return expenseService.getExpenseById(id);
	}
	
	@PostMapping
	public CompletableFuture<ExpenseEntity> createExpense(@RequestBody ExpenseEntity expense) {
		return expenseService.createExpense(expense);
	}
	
	@PutMapping("/{id}")
	public CompletableFuture<ExpenseEntity> updateExpense(@PathVariable int id, @RequestBody ExpenseEntity expenseDetails) {
		return expenseService.updateExpense(id, expenseDetails);
		
	}
	
	@DeleteMapping("/{id}")
	public CompletableFuture<Void> deleteExpense(@PathVariable int id) {
		return expenseService.deleteExpense(id);
	}
}
