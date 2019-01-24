package com.org.kk.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.org.kk.springpetclinic.model.Owner;
import com.org.kk.springpetclinic.model.Vet;
import com.org.kk.springpetclinic.services.OwnerService;
import com.org.kk.springpetclinic.services.VetService;
import com.org.kk.springpetclinic.services.map.OwnerServiceMap;
import com.org.kk.springpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	
	
	public DataLoader(OwnerService ownerService, VetService vetService) {
	
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	

	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Teflon");
		owner1.setLastName("Mike");
		owner1.setId(1L);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Don");
		owner2.setLastName("Self");
		owner2.setId(2L);
		
		ownerService.save(owner2);
		
		System.out.println("Loaded owners...");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Dr.Stan");
		vet1.setLastName("Shunpike");
		vet1.setId(1L);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Dr.Albus");
		vet2.setLastName("Dumbledore");
		vet2.setId(2L);
		
		vetService.save(vet2);
		
		System.out.println("Loaded vets...");
	}

}
