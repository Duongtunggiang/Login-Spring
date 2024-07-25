package com.duong.store.models;

import jakarta.validation.constraints.*;

public class RegisterDto {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @Email
    private String email;

    private String phone;

    private String address;

    @Size(min = 8, message = "Minium password length 8 characters")
    private String password;

    private String confirmPassword;

    public void setFirstName(@NotEmpty String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@NotEmpty String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(@NotEmpty @Email String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(@Size(min = 8, message = "Minium password length 8 characters") String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public @NotEmpty String getFirstName() {
        return firstName;
    }

    public @NotEmpty String getLastName() {
        return lastName;
    }

    public @NotEmpty @Email String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public @Size(min = 8, message = "Minium password length 8 characters") String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
