package com.org.kk.springpetclinic.services;

import com.org.kk.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>  {

	
	Owner findByLastName(String lastName);
}
