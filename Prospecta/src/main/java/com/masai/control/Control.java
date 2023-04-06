package com.masai.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.Category;
import com.masai.model.Entry;
import com.masai.model.ResultDto;
import com.masai.service.Service;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class Control {
	
	@Autowired
	Service a;
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<ResultDto>> getEntriesHandler(@PathVariable("category") String category) throws Category {
		
		 List<ResultDto> list=a.getTitleDesc(category);
		 return new ResponseEntity<List<ResultDto>>(list,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/entries")
	public ResponseEntity<String> saveEntriesHandler(@RequestBody Entry entry) {
		String s=a.saveEntry(entry);
		return new ResponseEntity<String>(s,HttpStatus.CREATED);
	}
	

}
