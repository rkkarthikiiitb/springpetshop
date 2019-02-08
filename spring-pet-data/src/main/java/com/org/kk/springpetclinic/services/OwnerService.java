package com.org.kk.springpetclinic.services;

import java.util.List;

import com.org.kk.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>  {

	
	Owner findByLastName(String lastName);
	List<Owner> findAllByLastNameLike(String lastName);
}
