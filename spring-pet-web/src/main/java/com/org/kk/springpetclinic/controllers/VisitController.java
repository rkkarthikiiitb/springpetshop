package com.org.kk.springpetclinic.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.org.kk.springpetclinic.model.Pet;
import com.org.kk.springpetclinic.model.Visit;
import com.org.kk.springpetclinic.services.PetService;
import com.org.kk.springpetclinic.services.VisitService;

@Controller
public class VisitController {

	private final VisitService visitService;
	private final PetService petService;
	private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

	public VisitController(VisitService visitService, PetService petService) {
		this.visitService = visitService;
		this.petService = petService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder databinder) {
		databinder.setDisallowedFields("id");
	}

	@ModelAttribute("visit")
	public Visit loadPetWithvisit(@PathVariable("petId") Long petId, Model model) {
		Pet pet = petService.findById(petId);
		model.addAttribute("pet", pet);
		Visit visits = new Visit();
		pet.getVisits().add(visits);
		visits.setPet(pet);
		return visits;
	}

	@GetMapping("/owners/*/pets/{petId}/visits/new")
	public String initNewVisitForm(@PathVariable("petId") Long petId, Model model) {

		return "pets/createOrUpdateVisitForm";
	}
	
	@PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
	public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
		if(result.hasErrors()) {
			return "pets/createOrUpdateVisitForm";
		}else {
			visitService.save(visit);
			return "redirect:/owners/{ownerId}";
		}
		
		
	}
}
