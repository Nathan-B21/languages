package com.bludworth.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bludworth.languages.models.Language;
import com.bludworth.languages.repositories.LanguageRepository;


@Service
public class LanguageService {
	private final LanguageRepository langRepository;
	public LanguageService(LanguageRepository langRepository) {
		this.langRepository = langRepository;
	}
	
	public List<Language> allLanguages(){
		return langRepository.findAll();	
	}
	
	public Language createLanguage(Language l) {
		return langRepository.save(l);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = langRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	
    public void deleteLanguage(Long id) {
    	langRepository.deleteById(id);
    }
    
    public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
    	Language language = findLanguage(id);
    	language.setName(name);
    	language.setCreator(creator);
    	language.setCurrentVersion(currentVersion);
    	
    	return langRepository.save(language);

    }
}
