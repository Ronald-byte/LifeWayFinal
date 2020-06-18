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
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Employees")
public class Employee implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmployee;
	
	@Column(name="nameEmployee",nullable = false,length = 50)
	private String nameEmployee;
	
	@Pattern(regexp = "[A-Z][a-z]*",message = "Ingrese el Apellido paterno nuevamente")
	@Column(name="paternalSurnameEmployee",nullable = false,length = 30)
	private String paternalSurnameEmployee;
	
	@Pattern(regexp = "[A-Z][a-z]*",message = "Ingrese el apellido materno nuevamente")
	@Column(name="maternalSurnameEmployee",nullable = false,length = 30)
	private String maternalSurnameEmployee;

	@Email(message = "Formato de correo invalido")
	@Column(name="emailEmployee",nullable = false,length = 30)
	private String emailEmployee;
	
	@Pattern(regexp="[\\d]{9}",message = "Vuelva a ingresar el numero celular")
	@Column(name = "phoneNumberEmployee",nullable = false, length = 9)
	private String phoneNumberEmployee;
	
	@Pattern(regexp="[\\d]{8}",message = "Vuelva a ingresar el DNI")
	@Column(name="dniEmployee",nullable = false,length = 8)
	private String dniEmployee;
	
	@ManyToOne
	@JoinColumn(name = "idTypeEmployee")
	private TypeEmployee typeEmployee;
	
	private String photoEmployee;
	
	public String getPhotoEmployee()
	{
		return photoEmployee;
	}
	
	public void setPhotoEmployee(String photoEmployee)
	{
		this.photoEmployee=photoEmployee;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int idEmployee, String nameEmployee, String paternalSurnameEmployee, String maternalSurnameEmployee,
			String emailEmployee, String phoneNumberEmployee,String dniEmployee, TypeEmployee typeEmployee, String photoEmployee) {
		super();
		this.idEmployee = idEmployee;
		this.nameEmployee = nameEmployee;
		this.paternalSurnameEmployee = paternalSurnameEmployee;
		this.maternalSurnameEmployee = maternalSurnameEmployee;
		this.emailEmployee = emailEmployee;
		this.phoneNumberEmployee = phoneNumberEmployee;
		this.dniEmployee=dniEmployee;
		this.typeEmployee = typeEmployee;
		this.photoEmployee=photoEmployee;
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

	public String getDniEmployee() {
		return dniEmployee;
	}

	public void setDniEmployee(String dniEmployee) {
		this.dniEmployee = dniEmployee;
	}

	public TypeEmployee getTypeEmployee() {
		return typeEmployee;
	}

	public void setTypeEmployee(TypeEmployee typeEmployee) {
		this.typeEmployee = typeEmployee;
	}
	
	
	
	
}
