package com.gmail.umarosman77.pft.util;

import org.modelmapper.ModelMapper;

import java.util.List;

public class PftUtil {

	private PftUtil() {

	}

	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		ModelMapper modelMapper = new ModelMapper();
		return source
				.stream()
				.map(element -> modelMapper.map(element, targetClass))
				.toList();
	}
}
