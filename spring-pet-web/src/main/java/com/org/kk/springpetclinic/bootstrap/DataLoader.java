package com.org.kk.springpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.kk.springpetclinic.model.Owner;
import com.org.kk.springpetclinic.model.Pet;
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
		owner1.setAddress("21 Dashund Place");
		owner1.setCity("Dallas");
		owner1.setTelephone("432-321-2341");
		
		Pet mikesPet = new Pet();
		mikesPet.setOwner(owner1);
		mikesPet.setPetType(savedPetTypeDog);
		mikesPet.setName("Butkus");
		mikesPet.setBirthDate(LocalDate.now());
		
		owner1.getPets().add(mikesPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Don");
		owner2.setLastName("Self");
		owner2.setAddress("3 Crimson Blvd");
		owner2.setCity("Dallas");
		owner2.setTelephone("412-324-2541");
		
		
		Pet donsPet = new Pet();
		donsPet.setOwner(owner2);
		donsPet.setPetType(savedPetTypeCat);
		donsPet.setName("Friggles");
		donsPet.setBirthDate(LocalDate.now());
		
		owner2.getPets().add(donsPet);

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
