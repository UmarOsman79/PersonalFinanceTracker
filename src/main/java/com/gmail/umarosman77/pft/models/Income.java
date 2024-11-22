package com.gmail.umarosman77.pft.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Income {

	private Integer id;
	private String description;
	private String comments;
	private Double value;
	private LocalDate createdDate = LocalDate.now();
}
