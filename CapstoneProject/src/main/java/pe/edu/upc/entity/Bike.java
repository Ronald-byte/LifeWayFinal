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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Bikes")
public class Bike implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBike;

	@ManyToOne
	@JoinColumn(name = "idBrand")
	private Brand brand;

	@Positive(message = "El monto debe de ser positivo")
	@Column(name = "costBike", nullable = false, columnDefinition = "Decimal(8,2)")
	private Double costBike;

	@NotNull(message = "La fecha es obligatoria")
	@Past(message = "La fecha debe estar en el pasado")
	@Column(name = "purchaseDateBike", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date purchaseDateBike;
	
	@ManyToOne
	@JoinColumn(name = "idStatus")
	private Status status;

	private String photoBike;

	
	public Bike(int idBike, Brand brand, Double costBike, Date purchaseDateBike, Status status, String photoBike) {
		super();
		this.idBike = idBike;
		this.brand = brand;
		this.costBike = costBike;
		this.purchaseDateBike = purchaseDateBike;
		this.status = status;
		this.photoBike = photoBike;
	}

	
	public Bike() {
		super();
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

	public Double getCostBike() {
		return costBike;
	}

	public void setCostBike(Double costBike) {
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

	public String getPhotoBike() {
		return photoBike;
	}

	public void setPhotoBike(String photoBike) {
		this.photoBike = photoBike;
	}
	
	
}
