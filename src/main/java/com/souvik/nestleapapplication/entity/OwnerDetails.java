package com.souvik.nestleapapplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "property")
public class OwnerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ownerName")
    private String ownerName;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "propertyLocation")
    private String propertyLocation;

    // ✅ Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPropertyLocation() { return propertyLocation; }
    public void setPropertyLocation(String propertyLocation) { this.propertyLocation = propertyLocation; }
}
