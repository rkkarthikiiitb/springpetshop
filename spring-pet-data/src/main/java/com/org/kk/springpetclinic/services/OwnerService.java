package com.org.kk.springpetclinic.services;

import java.util.Set;

import com.org.kk.springpetclinic.model.Owner;

public interface OwnerService  {

	Owner findById(Long Id);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();
	
	Owner findByLastName(String lastName);
}
