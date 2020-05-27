package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Bikes")
public class Bike implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBike;
	
	@ManyToOne
	@JoinColumn(name = "idBrand")
	private Brand brand;
	
	@Column(name = "costBike", nullable = false)
	private int costBike;
	
	@Column(name = "purchaseDateBike", nullable = false)
	private Date purchaseDateBike;
	
	@ManyToOne
	@JoinColumn(name = "idStatus")
	private Status status;
	
	public Bike(int idBike, Brand brand, int costBike, Date purchaseDateBike, Status status) {
		super();
		this.idBike = idBike;
		this.brand = brand;
		this.costBike = costBike;
		this.purchaseDateBike = purchaseDateBike;
		this.status = status;
	}

	
	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdBike() {
		return idBike;
	}

	public void setIdBike(int idBike) {
		this.idBike = idBike;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getCostBike() {
		return costBike;
	}

	public void setCostBike(int costBike) {
		this.costBike = costBike;
	}
	
	public Date getPurchaseDateBike() {
		return purchaseDateBike;
	}

	public void setPurchaseDateBike(Date purchaseDateBike) {
		this.purchaseDateBike = purchaseDateBike;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
