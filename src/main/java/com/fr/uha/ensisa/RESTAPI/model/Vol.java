package com.fr.uha.ensisa.RESTAPI.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vol")
public class Vol implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "numVol" , unique =  true)
	private String numVol;
	@Column(name = "villeDepart" , nullable = false)
	private String villeDepart;
	@Column(name = "villeArrivee" , nullable = false)
	private String villeArrivee;
	@Column(name = "heureDepart" , nullable = false)
	private int heureDepart;
	
	
	public Vol(String numVol, String villeDepart, String villeArrivee, int heureDepart) {
		super();
		this.numVol = numVol;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.heureDepart = heureDepart;
	}
	public Vol() {	}
	public String getNumVol() {
		return numVol;
	}
	public void setNumVol(String numVol) {
		this.numVol = numVol;
	}
	public String getVilleDepart() {
		return villeDepart;
	}
	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}
	public String getVilleArrivee() {
		return villeArrivee;
	}
	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}
	public int getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(int heureDepart) {
		this.heureDepart = heureDepart;
	}
	
	
}
