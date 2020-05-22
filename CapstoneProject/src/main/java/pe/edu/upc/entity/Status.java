package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Status")
public class Status implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStatus;
	
    @Column(name = "NStatus", nullable = false, length = 30)
    private String NStatus;

	public Status(int idStatus, String nStatus) {
		super();
		this.idStatus = idStatus;
		this.NStatus = nStatus;
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

	public String getNStatus() {
		return NStatus;
	}

	public void setNStatus(String nStatus) {
		NStatus = nStatus;
	}
   
}
