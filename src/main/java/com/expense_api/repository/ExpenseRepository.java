package com.expense_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense_api.entity.ExpenseEntity;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Integer>{

}
