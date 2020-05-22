package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Brand")
public class Brand implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBrand;
	
	@Column(name = "NBrand", nullable = false, length = 30)
	private String NBrand;

	public Brand(int idBrand, String nBrand) {
		super();
		this.idBrand = idBrand;
		this.NBrand = nBrand;
	}

	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(int idBrand) {
		this.idBrand = idBrand;
	}

	public String getNBrand() {
		return NBrand;
	}

	public void setNBrand(String nBrand) {
		NBrand = nBrand;
	}
	
}
