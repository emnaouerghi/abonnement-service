package com.example.demo;

import lombok.Data;

@Data
public class Activity {
	private Long id;
	
	private String nom;
	private String description;
	private float nbHeure;
	private float prix ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getNbHeure() {
		return nbHeure;
	}
	public void setNbHeure(float nbHeure) {
		this.nbHeure = nbHeure;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
}
