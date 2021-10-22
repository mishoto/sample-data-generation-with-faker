package dev.mihail.model;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = CUSTOMER_ID, nullable = false)
    private Long id;
    @Column(name = CUSTOMER_FN, nullable = false)
    private String firstName;
    @Column(name = CUSTOMER_LN, nullable = false)
    private String lastName;
    @Column(name = CUSTOMER_PHONE, nullable = false)
    private String phoneNumber;
    @Column(name = CUSTOMER_EMAIL)
    private String email;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = ADDRESS_ID, referencedColumnName = "address_id")
    private Address address;

    public static final String CUSTOMER_ID = "customer_id";
    public static final String CUSTOMER_FN = "customer_fn";
    public static final String CUSTOMER_LN = "customer_ln";
    public static final String CUSTOMER_PHONE = "customer_phone";
    public static final String CUSTOMER_EMAIL = "customer_email";
    public static final String ADDRESS_ID = "address_id";

    public Customer(){}

    public Customer(String firstName, String lastName, String phoneNumber, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", address=").append(address);
        sb.append('}');
        return sb.toString();
    }
}
