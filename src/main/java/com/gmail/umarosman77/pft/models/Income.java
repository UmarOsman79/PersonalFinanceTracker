package com.gmail.umarosman77.pft.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Income {

	private Integer id;
	private String description;
	private String comments;
	private Double value;
	private Date createdDate;
}
