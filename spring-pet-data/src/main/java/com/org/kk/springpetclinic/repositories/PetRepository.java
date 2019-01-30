package com.org.kk.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.org.kk.springpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
