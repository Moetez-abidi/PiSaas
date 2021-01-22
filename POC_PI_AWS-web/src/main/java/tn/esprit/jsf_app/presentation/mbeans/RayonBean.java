package tn.esprit.jsf_app.presentation.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.jsf_app.DTO.Rayon;
import tn.esprit.jsf_app.services.RayonService;

@ManagedBean(name = "RayonBean")
@SessionScoped
public class RayonBean implements Serializable {
	private Rayon rayon = new Rayon();
	private List<Rayon> rayons = new ArrayList<Rayon>();
	private static final long serialVersionUID = 1L;
	RayonService rayonService = new RayonService();

	public String addRayon() {
		rayonService.Create(rayon);
		rayon = new Rayon();
		return "OK";
	}

	public String supprimer(int id) {
		rayonService.DelRequest(id);
		return "Rayon.jsf";
	}

	/*
	 * Getter and setter
	 */
	
	
	public List<Rayon> getRayons() {
		rayons = rayonService.getAll();
		return rayons;
	}

	public void setRayons(List<Rayon> rayons) {
		this.rayons = rayons;
	}

	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}

}
