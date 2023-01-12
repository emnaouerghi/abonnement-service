package com.example.demo;

import java.sql.Date;

import lombok.Data;

@Data
public class User {
	private Long id;

	   private String email;
	    
	    private String password;
	    
		private String nom;
	    
	    private String prenom, adresse ;
	    private Date dateInscri;
		private String role;
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
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		
}
