package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @Column(name = "NCliente", nullable = false, length = 30)
    private String NCliente;
    
    @Column(name = "NApellido_P", nullable = false, length = 30)
    private String NApellido_P;
    
    @Column(name = "NApellido_M", nullable = false, length = 30)
    private String NApellido_M;
    
    @Column(name = "NCorreo", nullable = false, length = 30)
    private String NCorreo;
    
    @Column(name = "Telefono", nullable = false, length = 30)
    private int Telefono;
    
    @Column(name = "Direccion", nullable = false, length = 30)
    private int Direccion;

	public Cliente(int idCliente, String nCliente, String nApellido_P, String nApellido_M, String nCorreo, int telefono,
			int direccion) {
		super();
		this.idCliente = idCliente;
		NCliente = nCliente;
		NApellido_P = nApellido_P;
		NApellido_M = nApellido_M;
		NCorreo = nCorreo;
		Telefono = telefono;
		Direccion = direccion;
	}

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNCliente() {
		return NCliente;
	}

	public void setNCliente(String nCliente) {
		NCliente = nCliente;
	}

	public String getNApellido_P() {
		return NApellido_P;
	}

	public void setNApellido_P(String nApellido_P) {
		NApellido_P = nApellido_P;
	}

	public String getNApellido_M() {
		return NApellido_M;
	}

	public void setNApellido_M(String nApellido_M) {
		NApellido_M = nApellido_M;
	}

	public String getNCorreo() {
		return NCorreo;
	}

	public void setNCorreo(String nCorreo) {
		NCorreo = nCorreo;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public int getDireccion() {
		return Direccion;
	}

	public void setDireccion(int direccion) {
		Direccion = direccion;
	}


}
