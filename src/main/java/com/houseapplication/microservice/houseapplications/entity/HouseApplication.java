package com.houseapplication.microservice.houseapplications.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class HouseApplication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int applicationId;

    @Column(nullable = false)
    private String applicantFirstName;

    @Column(nullable = false)
    private String applicantLastName;

    @Column(nullable = false)
    private double houseArea;

    @Column(nullable = false)
    private String applicationStatus;

    @Column(nullable = false)
    private int applicationTypeId; // Residential = 0; Commercial= 1

    public HouseApplication(){

    }
//
////    public HouseApplication(int applicationID, String applicantFirstName, String applicantLastName, float houseArea, String applicationStatus) {
////        this.applicationID = applicationID;
////        this.applicantFirstName = applicantFirstName;
////        this.applicantLastName = applicantLastName;
////        this.houseArea = houseArea;
////        this.applicationStatus = applicationStatus;
////    }
    public HouseApplication(int applicationId) {
        this.applicationId = applicationId;

    }

    public int getApplicationId() {
        return applicationId;
    }

    public String getApplicantFirstName() {
        return applicantFirstName;
    }

    public void setApplicantFirstName(String applicantFirstName) {
        this.applicantFirstName = applicantFirstName;
    }

    public String getApplicantLastName() {
        return applicantLastName;
    }

    public void setApplicantLastName(String applicantLastName) {
        this.applicantLastName = applicantLastName;
    }

    public double getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(double houseArea) {
        this.houseArea = houseArea;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public int getApplicationTypeId() {
        return applicationTypeId;
    }

    public void setApplicationTypeId(int applicationTypeId) {
        this.applicationTypeId = applicationTypeId;
    }
}

