package com.org.kk.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.org.kk.springpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
