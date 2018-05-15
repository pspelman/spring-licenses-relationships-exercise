package com.philspelman.springlicensesrelationshipsexercise.models;

import com.philspelman.springlicensesrelationshipsexercise.repositories.LicenseRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "license")
public class License {

    public static Integer totalLicenses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;

    @Column
    private Date expirationDate;

    @Length(min = 2, max = 50)
    private String state;

    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public Person getPerson() {
        return person;
    }


    public void setPerson(Person person) {
        this.person = person;
    }

    public License() {
//        System.out.println("In the license constructor lite");
        this.number = getLicenseString();
    }

    public License(Date expirationDate, @Length(min = 2, max = 50) String state, Person person) {
        this.expirationDate = expirationDate;
        this.state = state;
        this.person = person;
        System.out.println("total licenses before new: " + totalLicenses);
//        this.number = getLicenseString(totalLicenses);

    }

    private String getLicenseString() {
        //figure out how many decimal places
        //get number of licenses in DB
        System.out.println("getting number of licenses in DB");


        System.out.println("formatted string should be: " + String.format("%08d", totalLicenses));
        return String.format("%08d", totalLicenses);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
    public String getExpirationDateString() {
        SimpleDateFormat localDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String date = localDateFormat.format(expirationDate);
        return date;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
