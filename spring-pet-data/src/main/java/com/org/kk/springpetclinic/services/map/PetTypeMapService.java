package com.org.kk.springpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.org.kk.springpetclinic.model.PetType;
import com.org.kk.springpetclinic.services.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapClass<PetType, Long> implements PetTypeService {

	@Override
	public Set<PetType> findAll() {
		
		return super.findAll();
	}

	@Override
	public PetType findById(Long id) {
		
		return super.findById(id);
	}

	@Override
	public PetType save(PetType object) {
		
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		
		super.deleteById(id);
	}

	@Override
	public void delete(PetType object) {
		
		super.delete(object);
	}
	
	

}
