package com.tcc.minhaloja.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.*;

public class ClientDto {


    @NotEmpty(message = "Primeiro nome é obrigatório")
    private String firstName;

    @NotEmpty(message = "Último nome é obrigatório")

    private String lastName;

    @NotEmpty(message = "Email é obrigatório")
    @Email
    private String email;
    private String phone;
    private String address;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
