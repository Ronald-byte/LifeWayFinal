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
@Table(name="RentalTicket")
public class RentalTicket implements Serializable {
 private static final long serialVersionUID = 1L;
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int idRental;
 
 @Column(name = "DateRental")
 private Date rentalDate;
 
 @Column(name = "NrHours", nullable = false, length = 30)
 private int numberHours;
 
 @Column(name = "CostRate", nullable = false, length = 30)
 private int costRate;
 
 @ManyToOne
 @JoinColumn(name = "idCustomer")
 private Customer customer;

 @Column(name = "TotalCost", nullable = false, length = 30)
 private int totalCost;

 @ManyToOne
 @JoinColumn(name = "idBike")
 private Bike bike;
 
 @ManyToOne
 @JoinColumn(name = "idEmployee")
 private Employee employee;

public RentalTicket() {
	super();
	// TODO Auto-generated constructor stub
}

public RentalTicket(int idRental, Date rentalDate, int numberHours, int costRate, Customer customer, int totalCost,
		Bike bike, Employee employee) {
	super();
	this.idRental = idRental;
	this.rentalDate = rentalDate;
	this.numberHours = numberHours;
	this.costRate = costRate;
	this.customer = customer;
	this.totalCost = totalCost;
	this.bike = bike;
	this.employee = employee;
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

public int getCostRate() {
	return costRate;
}

public void setCostRate(int costRate) {
	this.costRate = costRate;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public int getTotalCost() {
	return totalCost;
}

public void setTotalCost(int totalCost) {
	this.totalCost = totalCost;
}

public Bike getBike() {
	return bike;
}

public void setBike(Bike bike) {
	this.bike = bike;
}

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}
 
 
 
 
 
 
}
