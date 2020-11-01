package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idCustomer", nullable = false, unique=true)
	@Max(99999999)
	@Min(10000000)
    private int idCustomer;
	
	@Pattern(regexp = "[a-zA-Z]+", message = "El nombre solo puede tener caracteres")
    @Column(name = "nameCustomer", nullable = false, length = 30)
    private String nameCustomer;
	
	@Pattern(regexp = "[a-zA-Z]+", message = "El apellido paterno solo puede tener caracteres")
    @Column(name = "paternalSurnameCustomer", nullable = false, length = 30)
    private String paternalSurnameCustomer;
    
	@Pattern(regexp = "[a-zA-Z]+", message = "El apellido materno solo puede tener caracteres")
    @Column(name = "maternalSurnameCustomer", nullable = false, length = 30)
    private String maternalSurnameCustomer;
    
	@Email(message = "Formato de correo invalido")
    @Column(name = "emailCustomer", nullable = false, length = 30)
    private String emailCustomer;
    
	@Pattern(regexp = "[0-9]+", message = "El número de telefono solo puede tener valores numericos")
	@Size(min = 9, message = "El numero de telefono debe tener 9 caracteres")
    @Column(name = "phoneNumberCustomer", nullable = false, length = 9)
    private String phoneNumberCustomer;

	@Column(name = "addressCustomer", nullable = false, length = 50)
    private String addressCustomer;
	
	private Boolean enabled;


	public Customer(int idCustomer,
			String nameCustomer,
			 String paternalSurnameCustomer,
			String maternalSurnameCustomer,
			String emailCustomer,
			String phoneNumberCustomer,
			String addressCustomer, Boolean enabled) {
		super();
		this.idCustomer = idCustomer;
		this.nameCustomer = nameCustomer;
		this.paternalSurnameCustomer = paternalSurnameCustomer;
		this.maternalSurnameCustomer = maternalSurnameCustomer;
		this.emailCustomer = emailCustomer;
		this.phoneNumberCustomer = phoneNumberCustomer;
		this.addressCustomer = addressCustomer;
		this.enabled = enabled;
	}





	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}





    public int getIdCustomer() {
        return idCustomer;
    }

  
    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    
    public String getNameCustomer() {
        return nameCustomer;
    }


    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

  
    public String getPaternalSurnameCustomer() {
        return paternalSurnameCustomer;
    }


  
    public void setPaternalSurnameCustomer(String paternalSurnameCustomer) {
        this.paternalSurnameCustomer = paternalSurnameCustomer;
    }


    public String getMaternalSurnameCustomer() {
        return maternalSurnameCustomer;
    }


    public void setMaternalSurnameCustomer(String maternalSurnameCustomer) {
        this.maternalSurnameCustomer = maternalSurnameCustomer;
    }

  
    public String getEmailCustomer() {
        return emailCustomer;
    }


    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getPhoneNumberCustomer() {
        return phoneNumberCustomer;
    }

    
    public void setPhoneNumberCustomer(String phoneNumberCustomer) {
        this.phoneNumberCustomer = phoneNumberCustomer;
    }

 
    public String getAddressCustomer() {
        return addressCustomer;
    }

  
    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }





	public Boolean getEnabled() {
		return enabled;
	}





	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}



    
}