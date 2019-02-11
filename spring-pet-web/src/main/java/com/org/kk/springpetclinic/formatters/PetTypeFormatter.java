package com.org.kk.springpetclinic.formatters;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.org.kk.springpetclinic.model.PetType;
import com.org.kk.springpetclinic.services.PetTypeService;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

	private final PetTypeService petTypeService;

	public PetTypeFormatter(PetTypeService petTypeService) {

		this.petTypeService = petTypeService;
	}

	@Override
	public String print(PetType petType, Locale locale) {

		return petType.getPetName();
	}

	@Override
	public PetType parse(String text, Locale locale) throws ParseException {

		Collection<PetType> findPetTypes = petTypeService.findAll();
		
		for(PetType types : findPetTypes) {
			if(types.getPetName().equals(text)) {
				return types;
			}
		}
		throw new ParseException("type Not Found: "+text, 0);
	}

}
