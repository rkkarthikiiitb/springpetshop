package com.org.kk.springpetclinic.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.kk.springpetclinic.model.Owner;
import com.org.kk.springpetclinic.services.OwnerService;

@Controller
public class OwnerController {

	public static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {

		this.ownerService = ownerService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {

		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping({ "/owners/find", "/owners/find.html" })
	public String findOwners(Model model) {
		model.addAttribute("owner", Owner.builder().build());
		return "owners/findOwners";

	}

	@GetMapping("/owners")
	public String processFindForm(Owner owner, BindingResult result, Model model) {

		// allow parameterless GET request for /owners to return all records
		if (owner.getLastName() == null) {
			owner.setLastName(""); // empty string signifies broadest possible search
		}

		List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
		if (results.isEmpty()) {
			// empty result. No users found
			result.rejectValue("lastName", "notFound", "Not Found");
			return "owners/findOwners";
		} else if (results.size() == 1) {
			// one match found
			owner = results.get(0);

			return "redirect:owners/" + owner.getId();
		}

		else {
			model.addAttribute("selections", results);
			return "owners/ownersList";
		}

	}

	@GetMapping("/owners/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		mav.addObject(ownerService.findById(ownerId));
		return mav;
	}

	@GetMapping("/owners/new")
	public String initCreationForm(Model model) {

		model.addAttribute("owner", Owner.builder().build());
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping("/owners/new")
	public String processCreationForm(@Valid Owner owner, BindingResult result) {
		
		if(result.hasErrors()) {
			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		}else {
			
			Owner savedOwner = ownerService.save(owner);
			return "redirect:/owners/"+ savedOwner.getId();
		}
	}
	
	@GetMapping("/owners/{ownerId}/edit")
	public String initUpdateOwnerForm(@PathVariable("ownerId") Long ownerId, Model model) {
		
		
		model.addAttribute(ownerService.findById(ownerId));
		
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		
	}
	
	@PostMapping("/owners/{ownerId}/edit")
	public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable("ownerId") Long id) {
		if(result.hasErrors()) {
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		}else {
			
			owner.setId(id);
			Owner savedOwner = ownerService.save(owner);
			return "redirect:/owners/"+savedOwner.getId();
		}
	}
}
