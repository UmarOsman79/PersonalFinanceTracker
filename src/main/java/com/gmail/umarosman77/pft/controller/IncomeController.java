package com.gmail.umarosman77.pft.controller;

import com.gmail.umarosman77.pft.models.Income;
import com.gmail.umarosman77.pft.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("incomeController")
@RequestMapping("/income")
public class IncomeController {

	private final IncomeService incomeService;

	@Autowired
	public IncomeController(IncomeService incomeService) {
		this.incomeService = incomeService;
	}

	@PostMapping
	public ResponseEntity<Income> addIncome(@RequestBody Income income) {
		return new ResponseEntity<>(incomeService.addIncome(income), HttpStatus.OK);
	}
}
