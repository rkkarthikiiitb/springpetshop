package com.org.kk.springpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.org.kk.springpetclinic.model.Speciality;
import com.org.kk.springpetclinic.model.Vet;
import com.org.kk.springpetclinic.services.SpecialityService;
import com.org.kk.springpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapClass<Vet, Long> implements VetService {

	private final SpecialityService speciaityService;
	
	public VetServiceMap(SpecialityService speciaityService) {
	
	this.speciaityService = speciaityService;
}
@Override
	public Vet save(Vet object) {
		if(object.getSpecialities().size()>0) {
			object.getSpecialities().forEach(speciality -> {
				if(speciality.getId() == null) {
					Speciality savedSpecialty = speciaityService.save(speciality);
					speciality.setId(savedSpecialty.getId());
				}
			});
		}
		return super.save(object);
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
