package com.org.kk.springpetclinic.services;

import java.util.Set;

import com.org.kk.springpetclinic.model.Pet;

public interface PetService {
	
	Pet findById(Long Id);
	Pet save(Pet pet);
	Set<Pet> findAll();

}
