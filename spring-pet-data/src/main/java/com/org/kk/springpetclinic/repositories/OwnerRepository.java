package com.org.kk.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.org.kk.springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
