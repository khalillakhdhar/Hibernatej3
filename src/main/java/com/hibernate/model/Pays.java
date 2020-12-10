package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Pays {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String nom;
	@Column(nullable = false)
	private String continent;
	@Column(nullable = false)
	private double superficie;
	@Column(nullable = false)
	private long population;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public Pays(long id, String nom, String continent, double superficie, long population) {
		super();
		this.id = id;
		this.nom = nom;
		this.continent = continent;
		this.superficie = superficie;
		this.population = population;
	}
	public Pays() {
	}
	public Pays(String nom, String continent, double superficie, long population) {
		super();
		this.nom = nom;
		this.continent = continent;
		this.superficie = superficie;
		this.population = population;
	}
	@Override
	public String toString() {
		return "Pays [id=" + id + ", nom=" + nom + ", continent=" + continent + ", superficie=" + superficie
				+ ", population=" + population + "]";
	}
	
	
	
	
	
	
}
