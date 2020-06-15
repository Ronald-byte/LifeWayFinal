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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="RentalTickets")
public class RentalTicket implements Serializable {
 private static final long serialVersionUID = 1L;
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int idRentalTicket;
 
 @NotNull(message ="Ingrese una fecha válida")
 @Column(name = "rentalDateRentalTicket")
 @DateTimeFormat(pattern = "yyyy-MM-dd")
 private Date rentalDateRentalTicket;
 
 @Min(value = 1, message = "Debe registrar como mínimo una hora")
 @Column(name = "numberHoursRentalTicket", nullable = false)
 private int numberHoursRentalTicket;
 

 @Column(name = "costRateRentalTicket", nullable = false)
 private int costRateRentalTicket = 5; 
 
 @ManyToOne
 @JoinColumn(name = "idCustomer")
 private Customer customer;

 @Column(name = "totalCostRentalTicket", nullable = false)
 private int totalCostRentalTicket;

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

public RentalTicket(int idRentalTicket, Date rentalDateRentalTicket, int numberHoursRentalTicket,
		int costRateRentalTicket, Customer customer, int totalCostRentalTicket, Bike bike, Employee employee) {
	super();
	this.idRentalTicket = idRentalTicket;
	this.rentalDateRentalTicket = rentalDateRentalTicket;
	this.numberHoursRentalTicket = numberHoursRentalTicket;
	this.costRateRentalTicket = costRateRentalTicket;
	this.customer = customer;
	this.totalCostRentalTicket = totalCostRentalTicket;
	this.bike = bike;
	this.employee = employee;
}

public int getIdRentalTicket() {
	return idRentalTicket;
}

public void setIdRentalTicket(int idRentalTicket) {
	this.idRentalTicket = idRentalTicket;
}

public Date getRentalDateRentalTicket() {
	return rentalDateRentalTicket;
}

public void setRentalDateRentalTicket(Date rentalDateRentalTicket) {
	this.rentalDateRentalTicket = rentalDateRentalTicket;
}

public int getNumberHoursRentalTicket() {
	return numberHoursRentalTicket;
}

public void setNumberHoursRentalTicket(int numberHoursRentalTicket) {
	this.numberHoursRentalTicket = numberHoursRentalTicket;
}

public int getCostRateRentalTicket() {
	return costRateRentalTicket;
}

public void setCostRateRentalTicket(int costRateRentalTicket) {
	this.costRateRentalTicket = costRateRentalTicket;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public int getTotalCostRentalTicket() {
	return totalCostRentalTicket;
}

public void setTotalCostRentalTicket(int totalCostRentalTicket) {
	this.totalCostRentalTicket = totalCostRentalTicket;
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
