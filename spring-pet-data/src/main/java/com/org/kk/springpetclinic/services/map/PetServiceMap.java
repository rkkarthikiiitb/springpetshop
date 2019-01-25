package com.org.kk.springpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.org.kk.springpetclinic.model.Pet;
import com.org.kk.springpetclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapClass<Pet, Long> implements PetService{

	@Override
	public Pet save(Pet object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}
	
	@Override
	public void deleteById(Long Id) {
		super.deleteById(Id);
	}
	
	@Override
	public void delete(Pet object) {
		super.delete(object);
	}
	
	@Override
	public Set<Pet> findAll(){
		return super.findAll();
	}
	
	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

}
