package com.gmail.umarosman77.pft.services.impl;

import com.gmail.umarosman77.pft.entities.IncomeEntity;
import com.gmail.umarosman77.pft.models.Income;
import com.gmail.umarosman77.pft.repository.IncomeRepository;
import com.gmail.umarosman77.pft.services.IncomeService;
import com.gmail.umarosman77.pft.util.PftUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {

	private final IncomeRepository incomeRepository;

	@Autowired
	public IncomeServiceImpl(IncomeRepository incomeRepository) {
		this.incomeRepository = incomeRepository;
	}

	@Override
	public Income addIncome(Income income) {
		ModelMapper modelMapper = new ModelMapper();
		IncomeEntity incomeEntity = modelMapper.map(income, IncomeEntity.class);
		return modelMapper.map(incomeRepository.save(incomeEntity), Income.class);
	}

	@Override
	public List<Income> getAllIncome() {
		return PftUtil.mapList(incomeRepository.findAll(), Income.class);
	}

	@Override
	public List<Income> getIncomeInCurrentCalendarMonth() {
		LocalDate currentDate = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
		return PftUtil.mapList(incomeRepository.findIncomeInCurrentCalendarMonth(currentDate), Income.class);
	}
}
