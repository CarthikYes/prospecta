package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.masai.Exception.Category;
import com.masai.model.ApiDm;
import com.masai.model.Entry;
import com.masai.model.ResultDto;
import com.masai.repositry.ApiDataModelRepo;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ApiDataModelRepo apidm;

	@Override
	public List<ResultDto> getTitleDesc(String category) throws Category {
		
	 ApiDm adm=	restTemplate.getForObject("https://api.publicapis.org/entries", ApiDm.class);
		assert adm != null;
		List<Entry> entries= adm.getEntries();
	 
	 List<ResultDto> list= entries.stream().filter(ks -> ks.getCategory().equals(category)).map(ks -> new ResultDto(ks.getApi(), ks.getDescription())).toList();
		
	 if(list.size()==0) throw new Category("no data found with this category");
	 
	 return list;
	}

	@Override
	public String saveEntry(Entry entry) {
		// TODO Auto-generated method stub
		 List<Entry> ks= apidm.findAll();
		if(ks.size()==0) {
		 ApiDm adm=	restTemplate.getForObject("https://api.publicapis.org/entries", ApiDm.class);
			assert adm != null;
			List<Entry> entries= adm.getEntries();
		 for(Entry em:entries) {
			 apidm.save(em);
		 }
		 apidm.save(entry);
		}else {
			apidm.save(entry);
		}
		
		
		return "Saved ";
	}

}
