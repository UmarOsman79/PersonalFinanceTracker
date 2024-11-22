package com.gmail.umarosman77.pft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "income")
public class IncomeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "description")
	private String description;

	@Column(name = "comments")
	private String comments;

	@Column(name = "value")
	private Double value;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "created_date")
	private LocalDate createdDate;
}
