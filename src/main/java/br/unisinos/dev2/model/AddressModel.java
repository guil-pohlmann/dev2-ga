package br.unisinos.dev2.model;

import br.unisinos.dev2.dto.AddressDTO;


public class AddressModel extends AbstractModel {

    private String id;

    private String country;

    private String state;

    private String city;

    private String street;

    private String streetNumber;

    private String phoneNumber;

    private String postalCode;

    public AddressModel(){}

    //TODO maybe add a builder here?
    public AddressModel(AddressDTO address){
        this.country = address.getCountry();
        this.state = address.getState();
        this.city = address.getCity();
        this.street = address.getCity();
        this.streetNumber = address.getStreetNumber();
        this.phoneNumber = address.getPhoneNumber();
        this.postalCode = address.getPostalCode();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
