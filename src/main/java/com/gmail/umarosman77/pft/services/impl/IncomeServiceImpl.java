package com.gmail.umarosman77.pft.services.impl;

import com.gmail.umarosman77.pft.entities.IncomeEntity;
import com.gmail.umarosman77.pft.entities.UserEntity;
import com.gmail.umarosman77.pft.models.Income;
import com.gmail.umarosman77.pft.models.User;
import com.gmail.umarosman77.pft.repository.IncomeRepository;
import com.gmail.umarosman77.pft.services.IncomeService;
import com.gmail.umarosman77.pft.util.PftUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeServiceImpl implements IncomeService {

	private final IncomeRepository incomeRepository;

	@Autowired
	public IncomeServiceImpl(IncomeRepository incomeRepository) {
		this.incomeRepository = incomeRepository;
	}

	@Override
	public Income getIncome(Integer id) {
		Optional<IncomeEntity> optionalIncomeEntity = incomeRepository.findById(id);
		IncomeEntity incomeEntity = optionalIncomeEntity.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, MessageFormat.format("Income with id: {0} not found", id)));
		return new ModelMapper().map(incomeEntity, Income.class);
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

	@Override
	public void deleteIncome(Integer id) {
		Income income = this.getIncome(id);
		incomeRepository.delete(new ModelMapper().map(income, IncomeEntity.class));
	}
}
