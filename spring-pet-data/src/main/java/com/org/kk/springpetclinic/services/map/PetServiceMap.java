package com.org.kk.springpetclinic.services.map;

import java.util.Set;

import com.org.kk.springpetclinic.model.Pet;
import com.org.kk.springpetclinic.services.CrudService;

public class PetServiceMap extends AbstractMapClass<Pet, Long> implements CrudService<Pet, Long>{

	@Override
	public Pet save(Pet object) {
		// TODO Auto-generated method stub
		return super.save(object.getId(), object);
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
