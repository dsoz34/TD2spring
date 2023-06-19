package com.inti;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Produit {

	@Id
	@GeneratedValue
	private int id;
	private static double taxe = 1.2;
	private String nom;
	private double prix;
	
	
	protected Produit() {}


	public double calculHT() {
		return prix* (1/taxe);
	}


	public Produit(String nom, double prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}


	public Produit(int id, String nom, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
	}
	
	
	
	
	
}
