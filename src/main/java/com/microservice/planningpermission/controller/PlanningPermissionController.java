package com.microservice.planningpermission.controller;

import com.microservice.planningpermission.repository.PlanningPermissionRepository;
import com.microservice.planningpermission.entity.PlanningPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Service
public class PlanningPermissionController {

    @Autowired
    PlanningPermissionRepository planningPermissionRepository;

    @RequestMapping("/planningPermission/{referenceId}")
    Optional<PlanningPermission> getHouseApplication(@PathVariable("referenceId") int referenceId){
        return planningPermissionRepository.findById(referenceId);
    }
    @RequestMapping("/planningPermissions")
    List<PlanningPermission> getHouseApplicationForApplicationType(@RequestParam("referenceId") int referenceId){
        return planningPermissionRepository.findByApplicationTypeId(referenceId);
    }
    @RequestMapping(value= "/planningPermission", method= RequestMethod.POST)
    ResponseEntity<PlanningPermission>insertHousingApplication(@RequestBody PlanningPermission planningPermission){
        PlanningPermission savedPlanningPermission = planningPermissionRepository.save(planningPermission);
        return new ResponseEntity<PlanningPermission>(savedPlanningPermission, HttpStatus.OK);
    }
    @RequestMapping(value= "/planningPermission/{referenceId}", method= RequestMethod.PUT)
    PlanningPermission updateHousingApplication(@PathVariable("referenceId") int referenceId, @RequestBody PlanningPermission planningPermission){
        Optional<PlanningPermission> optionalPlanningPermission = planningPermissionRepository.findById(referenceId);
        PlanningPermission existingPlanningPermission = optionalPlanningPermission.get();

        existingPlanningPermission.setApplicantFirstName(planningPermission.getApplicantFirstName());
        existingPlanningPermission.setApplicantLastName(planningPermission.getApplicantLastName());
        existingPlanningPermission.setHouseArea(planningPermission.getHouseArea());
        existingPlanningPermission.setApplicationTypeId(planningPermission.getApplicationTypeId());

        PlanningPermission savedPlanningPermission = planningPermissionRepository.save(existingPlanningPermission);
        return savedPlanningPermission;
    }
    @RequestMapping(value= "/planningPermission/{referenceId}", method= RequestMethod.DELETE)
    PlanningPermission deleteHousingApplication(@PathVariable("referenceId") int referenceId){
        Optional<PlanningPermission> optionalPlanningPermission = planningPermissionRepository.findById(referenceId);
        PlanningPermission existingPlanningPermission = optionalPlanningPermission.get();

        planningPermissionRepository.delete(existingPlanningPermission);
        return existingPlanningPermission;
    }

}
