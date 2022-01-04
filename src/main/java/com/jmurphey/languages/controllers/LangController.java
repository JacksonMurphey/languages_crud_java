package com.jmurphey.languages.controllers;

import java.util.List;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jmurphey.languages.models.Language;
import com.jmurphey.languages.services.LangService;



@Controller
@RequestMapping("/languages")
public class LangController {
	
	private final LangService langService;
	public LangController(LangService langService) {
		this.langService = langService;
	}
	
	
	
	@GetMapping("")
	public String index(@ModelAttribute("lang")Language lang, Model model) {
		List<Language> langs = langService.allLangs();
		model.addAttribute("langs", langs);
		return "langs.jsp";
	}
	
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("lang") Language lang, BindingResult result) {
		if (result.hasErrors()) {
			
			return "langs.jsp";
		} else {
			langService.createLang(lang);
			return "redirect:/languages";
		}
	}
	
	
	@GetMapping("/{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("lang", this.langService.getLang(id));
		return "show.jsp";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model) {
		model.addAttribute("lang", this.langService.getLang(id));
		return "edit.jsp";
	}
	
	
	@PutMapping("/{id}")
	public String update(@Valid @ModelAttribute("lang")Language lang, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			langService.updateLang(lang);
			return "redirect:/languages";
		}
	}
	
	
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable Long id) {
		langService.delete(id);
		return "redirect:/languages";
	}
	
	
	
}
