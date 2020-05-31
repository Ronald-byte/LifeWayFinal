package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmployee;
	
	@Column(name="nameEmployee",nullable = false,length = 50)
	private String nameEmployee;
	
	@Column(name="paternalSurnameEmployee",nullable = false,length = 30)
	private String paternalSurnameEmployee;
	
	@Column(name="maternalSurnameEmployee",nullable = false,length = 30)
	private String maternalSurnameEmployee;
	

	//@Email
	@Column(name="emailEmployee",nullable = false,length = 30)
	private String emailEmployee;
	
	@Column(name = "phoneNumberEmployee",nullable = false, length = 9)
	private String phoneNumberEmployee;
	
	@ManyToOne
	@JoinColumn(name = "idTypeEmployee")
	private TypeEmployee typeEmployee;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int idEmployee, String nameEmployee, String paternalSurnameEmployee, String maternalSurnameEmployee,
			String emailEmployee, String phoneNumberEmployee, TypeEmployee typeEmployee) {
		super();
		this.idEmployee = idEmployee;
		this.nameEmployee = nameEmployee;
		this.paternalSurnameEmployee = paternalSurnameEmployee;
		this.maternalSurnameEmployee = maternalSurnameEmployee;
		this.emailEmployee = emailEmployee;
		this.phoneNumberEmployee = phoneNumberEmployee;
		this.typeEmployee = typeEmployee;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	public String getPaternalSurnameEmployee() {
		return paternalSurnameEmployee;
	}

	public void setPaternalSurnameEmployee(String paternalSurnameEmployee) {
		this.paternalSurnameEmployee = paternalSurnameEmployee;
	}

	public String getMaternalSurnameEmployee() {
		return maternalSurnameEmployee;
	}

	public void setMaternalSurnameEmployee(String maternalSurnameEmployee) {
		this.maternalSurnameEmployee = maternalSurnameEmployee;
	}

	public String getEmailEmployee() {
		return emailEmployee;
	}

	public void setEmailEmployee(String emailEmployee) {
		this.emailEmployee = emailEmployee;
	}

	public String getPhoneNumberEmployee() {
		return phoneNumberEmployee;
	}

	public void setPhoneNumberEmployee(String phoneNumberEmployee) {
		this.phoneNumberEmployee = phoneNumberEmployee;
	}

	public TypeEmployee getTypeEmployee() {
		return typeEmployee;
	}

	public void setTypeEmployee(TypeEmployee typeEmployee) {
		this.typeEmployee = typeEmployee;
	}
	
	
	
	
}
