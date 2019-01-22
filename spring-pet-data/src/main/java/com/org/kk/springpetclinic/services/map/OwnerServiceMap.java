package com.org.kk.springpetclinic.services.map;

import java.util.Set;

import com.org.kk.springpetclinic.model.Owner;
import com.org.kk.springpetclinic.services.CrudService;

public class OwnerServiceMap extends AbstractMapClass<Owner, Long> implements CrudService<Owner, Long> {

	
	@Override
	public Set<Owner>findAll(){
		return super.findAll();
	}
	
	@Override
	public Owner findById(Long Id) {
		return super.findById(Id);
	}
	@Override
	public Owner save(Owner object) {
		// TODO Auto-generated method stub
		return super.save(object.getId(),object);
	}

	@Override
	public void delete(Owner object) {
		// TODO Auto-generated method stub
		super.delete(object);
		
	}
	
	@Override
	public void deleteById(Long Id) {
		super.deleteById(Id);
	}

}
