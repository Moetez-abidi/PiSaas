package tn.esprit.jsf_app.interfaces;
import  java.util.List;
import tn.esprit.jsf_app.DTO.Rayon;

public interface RayonServiceLoc {
	public List<Rayon>  getAll();
   	public void Create(Rayon p);
	public void DelRequest(int id);
	public void Update(int id, Rayon pv);
}
