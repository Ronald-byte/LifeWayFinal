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
@Table(name="Status")
public class Status implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStatus;
	
	@Pattern(regexp = "[a-zA-Z-' '-ñ-Ñ]+", message = "El nombre solo puede tener caracteres")
    @Column(name = "nameStatus", nullable = false, length = 30)
    private String nameStatus;



	public Status(int idStatus, String nameStatus) {
		super();
		this.idStatus = idStatus;
		this.nameStatus = nameStatus;
	}

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getNameStatus() {
		return nameStatus;
	}

	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}


}
