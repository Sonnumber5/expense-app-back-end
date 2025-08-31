package com.expense_api.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.expense_api.entity.ExpenseEntity;
import com.expense_api.repository.ExpenseRepository;

@Service
public class ExpenseService {

	private final ExpenseRepository _expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		_expenseRepository = expenseRepository;
	}
	
	@Async
	public CompletableFuture<List<ExpenseEntity>> getAllExpenses(){
		return CompletableFuture.completedFuture(_expenseRepository.findAll());
	}
	
	@Async
	public CompletableFuture<ExpenseEntity> getExpenseById(int id){
		return CompletableFuture.completedFuture(_expenseRepository.findById(id).orElse(null));
	}
	
	@Async
	public CompletableFuture<ExpenseEntity> createExpense(ExpenseEntity expense){
		return CompletableFuture.completedFuture(_expenseRepository.save(expense));
	}
	
	@Async
	public CompletableFuture<ExpenseEntity> updateExpense(int id, ExpenseEntity expenseDetails){
		return CompletableFuture.completedFuture(_expenseRepository.findById(id).map(expense -> {
			expense.setTitle(expenseDetails.getTitle());
			expense.setAmount(expenseDetails.getAmount());
			expense.setDate(expenseDetails.getDate());
			expense.setDescription(expenseDetails.getDescription());
			return _expenseRepository.save(expense);
		}).orElse(null));
	}
	
	@Async
	public CompletableFuture<Void> deleteExpense(int id){
		_expenseRepository.deleteById(id);
		return CompletableFuture.completedFuture(null);
	}
	
}
