package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;

    @Column(name = "nameCustomer", nullable = false, length = 30)
    private String nameCustomer;
    
    @Column(name = "paternalSurnameCustomer", nullable = false, length = 30)
    private String paternalSurnameCustomer;
    
    @Column(name = "maternalSurnameCustomer", nullable = false, length = 30)
    private String maternalSurnameCustomer;
    
    @Column(name = "emailCustomer", nullable = false, length = 30)
    private String emailCustomer;
    
    @Column(name = "phoneNumberCustomer", nullable = false, length = 9)
    private String phoneNumberCustomer;

    @Column(name = "addressCustomer", nullable = false, length = 50)
    private String addressCustomer;


    public Customer(int idCustomer, String nameCustomer, String paternalSurnameCustomer, String maternalSurnameCustomer, String emailCustomer, String phoneNumberCustomer, String addressCustomer) {
		super();
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.paternalSurnameCustomer = paternalSurnameCustomer;
        this.maternalSurnameCustomer = maternalSurnameCustomer;
        this.emailCustomer = emailCustomer;
        this.phoneNumberCustomer = phoneNumberCustomer;
        this.addressCustomer = addressCustomer;
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

}