package com.jmurphey.languages.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jmurphey.languages.models.Language;

@Repository
public interface LangRepo extends CrudRepository<Language, Long>{
	
	List<Language> findAll();
	
	Optional<Language> findById(Long id);
	
	
}
