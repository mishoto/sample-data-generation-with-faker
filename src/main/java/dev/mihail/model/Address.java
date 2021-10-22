package dev.mihail.model;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ADDRESS_ID, nullable = false)
    private Long id;
    @Column(name = COUNTRY, nullable = false)
    private String country;
    @Column(name = CITY, nullable = false)
    private String city;
    @Column(name = STREET_NAME, nullable = false)
    private String streetName;
    @Column(name = STREET_NUMBER, nullable = false)
    private String streetNumber;
    @Column(name = STATE, nullable = false)
    private String state;

    public static final String ADDRESS_ID = "address_id";
    public static final String COUNTRY = "country";
    public static final String CITY = "city";
    public static final String STREET_NAME = "street_name";
    public static final String STREET_NUMBER = "street_number";
    public static final String STATE = "state";

    public Address() {
    }

    public Address(String country, String city, String streetName, String streetNumber, String state) {
        this.country = country;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("id=").append(id);
        sb.append(", country='").append(country).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", streetName='").append(streetName).append('\'');
        sb.append(", streetNumber='").append(streetNumber).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


