package com.org.kk.springpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {
	
	@Column(name="name")
	private String petName;

	@Override
	public String toString() {
		return petName;
	}
	
	@Builder
	public PetType(long id, String petName) {
		super(id);
		this.petName = petName;
	}
	



}
