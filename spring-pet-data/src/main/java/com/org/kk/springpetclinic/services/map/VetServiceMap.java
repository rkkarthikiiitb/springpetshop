package com.org.kk.springpetclinic.services.map;

import java.util.Set;

import com.org.kk.springpetclinic.model.Vet;
import com.org.kk.springpetclinic.services.VetService;

public class VetServiceMap extends AbstractMapClass<Vet, Long> implements VetService {

	@Override
	public Vet save(Vet object) {
		// TODO Auto-generated method stub
		return super.save(object.getId(), object);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
	@Override
	public void delete(Vet object) {
		super.delete(object);
	}
	
	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public Set<Vet> findAll(){
		
		return super.findAll();
	}
	

}
