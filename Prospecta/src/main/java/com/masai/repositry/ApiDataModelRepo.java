package com.masai.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Entry;
@Repository
public interface ApiDataModelRepo extends JpaRepository<Entry, String> {

}
