package com.microservice.planningpermission.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "planning_permission")
public class PlanningPermission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int referenceId;

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

    public PlanningPermission(){

    }

    public PlanningPermission(int referenceId, String applicantFirstName, String applicantLastName, double houseArea, String applicationStatus, int applicationTypeId) {
        this.referenceId = referenceId;
        this.applicantFirstName = applicantFirstName;
        this.applicantLastName = applicantLastName;
        this.houseArea = houseArea;
        this.applicationStatus = applicationStatus;
        this.applicationTypeId = applicationTypeId;
    }

    public int getReferenceId() {
        return referenceId;
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
