package com.gmail.umarosman77.pft.repository;

import com.gmail.umarosman77.pft.entities.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IncomeRepository extends JpaRepository<IncomeEntity, Integer> {

	@Query(value = "Select i from income i where i.createdDate >= :date")
	List<IncomeEntity> findIncomeInCurrentCalendarMonth(@Param("date") LocalDate date);
}
