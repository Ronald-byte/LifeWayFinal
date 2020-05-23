package pe.edu.upc.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="RentalTicket")
public class RentalTicket implements Serializable {
 private static final long serialVersionUID = 1L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int idRental;
 
 private Date rentalDate;
 
 private int numberHours;
 
 private int numberCost;
 
 private int totalCost;

public RentalTicket(int idRental, Date rentalDate, int numberHours, int numberCost, int totalCost) {
	super();
	this.idRental = idRental;
	this.rentalDate = rentalDate;
	this.numberHours = numberHours;
	this.numberCost = numberCost;
	this.totalCost = totalCost;
}

public RentalTicket() {
	super();
	// TODO Auto-generated constructor stub
}

public int getIdRental() {
	return idRental;
}

public void setIdRental(int idRental) {
	this.idRental = idRental;
}

public Date getRentalDate() {
	return rentalDate;
}

public void setRentalDate(Date rentalDate) {
	this.rentalDate = rentalDate;
}

public int getNumberHours() {
	return numberHours;
}

public void setNumberHours(int numberHours) {
	this.numberHours = numberHours;
}

public int getNumberCost() {
	return numberCost;
}

public void setNumberCost(int numberCost) {
	this.numberCost = numberCost;
}

public int getTotalCost() {
	return totalCost;
}

public void setTotalCost(int totalCost) {
	this.totalCost = totalCost;
}
 
 
 
}
