package com.gmail.umarosman77.pft.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	private Integer id;
	private String username;
}
