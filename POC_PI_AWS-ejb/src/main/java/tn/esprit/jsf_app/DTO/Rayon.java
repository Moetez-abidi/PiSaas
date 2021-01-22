package tn.esprit.jsf_app.DTO;

public class Rayon {
	public int id;
	public String productName;
	public String rayonType;
	
	
	
	public Rayon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rayon(int id, String productName, String rayonType) {
		super();
		this.id = id;
		this.productName = productName;
		this.rayonType = rayonType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getRayonType() {
		return rayonType;
	}
	public void setRayonType(String rayonType) {
		this.rayonType = rayonType;
	}
	
	

}
