package com.houseapplication.microservice.houseapplications;

import com.houseapplication.microservice.houseapplications.dao.HouseApplicationRepository;
import com.houseapplication.microservice.houseapplications.entity.HouseApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@Service
public class HouseApplicationService {

    @Autowired
    HouseApplicationRepository houseAppRepo;

    @RequestMapping("/housingApplication/{applicationId}")
    Optional<HouseApplication> getHouseApplication(@PathVariable("applicationId") int applicationId){
        return houseAppRepo.findById(applicationId);
    }
    @RequestMapping("/housingApplications")
    List<HouseApplication> getHouseApplicationForApplicationType(@RequestParam("applicationId") int applicationId){
        return houseAppRepo.findByApplicationTypeId(applicationId);
    }
    @RequestMapping(value="/housingApplication", method= RequestMethod.POST)
    ResponseEntity<HouseApplication>insertHousingApplication(@RequestBody HouseApplication housingApplication){
        HouseApplication savedHousingApplication = houseAppRepo.save(housingApplication);
        return new ResponseEntity<HouseApplication>(savedHousingApplication, HttpStatus.OK);
    }
    @RequestMapping(value="/housingApplication/{applicationId}", method= RequestMethod.PUT)
    HouseApplication updateHousingApplication(@PathVariable("applicationId") int applicationId, @RequestBody HouseApplication housingApplication){
        Optional<HouseApplication> optionalHouseApplication = houseAppRepo.findById(applicationId);
        HouseApplication existingHouseApplication = optionalHouseApplication.get();

        existingHouseApplication.setApplicantFirstName(housingApplication.getApplicantFirstName());
        existingHouseApplication.setApplicantLastName(housingApplication.getApplicantLastName());
        existingHouseApplication.setHouseArea(housingApplication.getHouseArea());
        existingHouseApplication.setApplicationTypeId(housingApplication.getApplicationTypeId());

        HouseApplication savedHousingApplication = houseAppRepo.save(existingHouseApplication);
        return savedHousingApplication;
    }
    @RequestMapping(value="/housingApplication/{applicationId}", method= RequestMethod.DELETE)
    HouseApplication deleteHousingApplication(@PathVariable("applicationId") int applicationId){
        Optional<HouseApplication> optionalHouseApplication = houseAppRepo.findById(applicationId);
        HouseApplication existingHouseApplication = optionalHouseApplication.get();

        houseAppRepo.delete(existingHouseApplication);
        return existingHouseApplication;
    }

}
