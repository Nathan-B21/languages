package com.bludworth.languages.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bludworth.languages.models.Language;
import com.bludworth.languages.services.LanguageService;



@Controller
public class LanguagesController {
	private final LanguageService langService;
	public LanguagesController(LanguageService langService) {
		this.langService = langService;
	}
	
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = langService.allLanguages();
		model.addAttribute("languages", languages);
		System.out.println(languages);
		return "/languages/languages.jsp";
	}
	
//	@RequestMapping("/newlanguages")
//	public String newLanguage(@ModelAttribute("language") Language language) {
//		return "/languages/languages.jsp";
//	}
	
	@RequestMapping(value="/newlanguages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/languages.jsp";
		}else {
			langService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String showLanguage(@PathVariable("id") Long id, Model model) {
		Language language = langService.findLanguage(id);
		
//		if(language!=null) {
		model.addAttribute("language", language);	
//		}
		System.out.println(language.getName());
		return "/languages/show.jsp";
	}
	
	@RequestMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model ) {
		Language language = langService.findLanguage(id);
		model.addAttribute("language", language);
		return "/languages/edit.jsp";
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String update (@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "/languages/edit.jsp";
		} else {
			langService.updateLanguage(language.getId(), language.getName(), language.getCreator(), language.getCurrentVersion());
			return "redirect:/languages";
		}// *****************************ASK ABOUT THIS I THINK IT'S WRONG***************************************
	}
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		langService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
