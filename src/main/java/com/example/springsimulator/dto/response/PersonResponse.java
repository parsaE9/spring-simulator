package com.example.springsimulator.dto.response;

import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class PersonResponse {

    private String nationalCode;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String birthdate;

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {

        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        Date formatted_birthdate = null;

        try {
            formatted_birthdate = formatter1.parse(birthdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "PersonRequest{" +
                "nationalCode='" + nationalCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", birthdate='" + formatted_birthdate + '\'' +
                '}';
    }
}
