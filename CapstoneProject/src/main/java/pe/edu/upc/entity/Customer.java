package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;

    @Column(name = "NCustomer", nullable = false, length = 30)
    private String NCustomer;
    
    @Column(name = "NPaternalSurname", nullable = false, length = 30)
    private String NPaternalSurname;
    
    @Column(name = "NMaternalSurname", nullable = false, length = 30)
    private String NMaternalSurname;
    
    @Column(name = "Mail", nullable = false, length = 30)
    private String Mail;
    
    @Column(name = "PhoneNumber", nullable = false, length = 30)
    private int PhoneNumber;
    @Column(name = "Address", nullable = false, length = 30)
    private int Address;

}