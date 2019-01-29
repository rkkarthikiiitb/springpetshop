package com.org.kk.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.kk.springpetclinic.model.Owner;
import com.org.kk.springpetclinic.model.PetType;
import com.org.kk.springpetclinic.model.Vet;
import com.org.kk.springpetclinic.services.OwnerService;
import com.org.kk.springpetclinic.services.PetTypeService;
import com.org.kk.springpetclinic.services.VetService;
import com.org.kk.springpetclinic.services.map.OwnerServiceMap;
import com.org.kk.springpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {

		PetType dog = new PetType();
		dog.setPetName("Doggo");
		PetType savedPetTypeDog = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setPetName("Whiska");
		PetType savedPetTypeCat = petTypeService.save(cat);
		System.out.println("Loaded pet types...");

		Owner owner1 = new Owner();
		owner1.setFirstName("Teflon");
		owner1.setLastName("Mike");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Don");
		owner2.setLastName("Self");

		ownerService.save(owner2);

		System.out.println("Loaded owners...");

		Vet vet1 = new Vet();
		vet1.setFirstName("Dr.Stan");
		vet1.setLastName("Shunpike");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Dr.Albus");
		vet2.setLastName("Dumbledore");

		vetService.save(vet2);

		System.out.println("Loaded vets...");
	}

}
