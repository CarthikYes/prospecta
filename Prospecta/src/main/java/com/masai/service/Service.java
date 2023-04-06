package com.masai.service;

import java.util.List;

import com.masai.Exception.Category;
import com.masai.model.Entry;
import com.masai.model.ResultDto;

public interface Service {
	
	List<ResultDto> getTitleDesc(String category) throws Category;
	String saveEntry(Entry entry);

}
