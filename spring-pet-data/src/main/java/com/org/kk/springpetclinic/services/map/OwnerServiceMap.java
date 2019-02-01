package com.org.kk.springpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.org.kk.springpetclinic.model.Owner;
import com.org.kk.springpetclinic.model.Pet;
import com.org.kk.springpetclinic.services.OwnerService;
import com.org.kk.springpetclinic.services.PetService;
import com.org.kk.springpetclinic.services.PetTypeService;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapClass<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {

		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long Id) {
		return super.findById(Id);
	}

	@Override
	public Owner save(Owner object) {

		if (object != null) {
			if (object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if (pet.getPetType() != null) {
						if (pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					} else {
						throw new RuntimeException("Pet type is required...");
					}
					if (pet.getId() == null) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			return super.save(object);
		} else {
			return null;
		}

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

	@Override
	public Owner findByLastName(String lastName) {

		return null;

	}

}
