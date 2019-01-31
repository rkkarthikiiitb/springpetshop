package com.org.kk.springpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.org.kk.springpetclinic.model.Pet;
import com.org.kk.springpetclinic.repositories.PetRepository;
import com.org.kk.springpetclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

	private final PetRepository petrepository;

	public PetSDJpaService(PetRepository petrepository) {

		this.petrepository = petrepository;
	}

	@Override
	public Set<Pet> findAll() {

		Set<Pet> pets = new HashSet<>();
		petrepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		
		return petrepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		
		return petrepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		
		petrepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		
		petrepository.deleteById(id);

	}

}
