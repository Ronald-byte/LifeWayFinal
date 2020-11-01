package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "TypeEmployees")
public class TypeEmployee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTypeEmployee;

	@NotBlank
	@Pattern(regexp = "[a-zA-Z-' ']+", message = "El nombre solo puede tener caracteres")
	@Column(name = "nameTypeEmployee", nullable = false, length = 30)
	private String nameTypeEmployee;

	public TypeEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeEmployee(int idTypeEmployee, String nameTypeEmployee) {
		super();
		this.idTypeEmployee = idTypeEmployee;
		this.nameTypeEmployee = nameTypeEmployee;
	}

	public int getIdTypeEmployee() {
		return idTypeEmployee;
	}

	public void setIdTypeEmployee(int idTypeEmployee) {
		this.idTypeEmployee = idTypeEmployee;
	}

	public String getNameTypeEmployee() {
		return nameTypeEmployee;
	}

	public void setNameTypeEmployee(String nameTypeEmployee) {
		this.nameTypeEmployee = nameTypeEmployee;
	}

	
	
}
