package com.jmurphey.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jmurphey.languages.models.Language;
import com.jmurphey.languages.repositories.LangRepo;

@Service
public class LangService {

	private final LangRepo repo;
	
	// Constructor
	public LangService(LangRepo repo) {
		this.repo = repo;
	}
	
	// Get all 
	public List<Language> allLangs(){
		return repo.findAll();
	}
	
	// Create
	public Language createLang(Language lang) {
		return repo.save(lang);
	}
	
	
	// Get one 
	public Language findLang(Long id) {
		Optional<Language> optionalLang = repo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	public Language getLang(Long id) {
		return this.findLang(id);
	}
	
	// Delete one
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	// Update one
	public Language updateLang(Language lang) {
		return this.repo.save(lang);
	}
	
	
}
