package com.gmail.umarosman77.pft.services;

import com.gmail.umarosman77.pft.models.Income;

import java.util.List;

public interface IncomeService {

	Income getIncome(Integer id);

	Income addIncome(Income income);

	List<Income> getAllIncome();

	List<Income> getIncomeInCurrentCalendarMonth();

	void deleteIncome(Integer id);
}
