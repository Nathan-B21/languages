package com.bludworth.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bludworth.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	List<Language> findAll();
	
	List<Language> findBynameContaining(String search); //is this right?
	
	//void deleteByRoleId(long roleId); // is this right?
}
