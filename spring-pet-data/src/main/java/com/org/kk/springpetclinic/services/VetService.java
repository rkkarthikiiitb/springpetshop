package com.org.kk.springpetclinic.services;

import java.util.Set;

import com.org.kk.springpetclinic.model.Vet;

public interface VetService {

	Vet findById(Long Id);
	Vet save(Vet vet);
	Set<Vet> findAll();
}
