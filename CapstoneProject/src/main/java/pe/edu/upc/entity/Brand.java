package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Brands")
public class Brand implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBrand;
	
	@Pattern(regexp = "[a-zA-Z-' ']+", message = "El nombre solo puede tener caracteres")
	@Column(name = "nameBrand", nullable = false, length = 30)
	private String nameBrand;


	public Brand(int idBrand, String nameBrand) {
		super();
		this.idBrand = idBrand;
		this.nameBrand = nameBrand;
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
	public String getNameBrand() {
		return nameBrand;
	}
	public void setNameBrand(String nameBrand) {
		this.nameBrand = nameBrand;
	}
}
