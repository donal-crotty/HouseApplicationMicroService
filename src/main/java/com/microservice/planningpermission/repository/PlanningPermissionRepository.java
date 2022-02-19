package com.microservice.planningpermission.repository;

import com.microservice.planningpermission.entity.PlanningPermission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanningPermissionRepository extends CrudRepository<PlanningPermission, Integer> {
    List<PlanningPermission> findByApplicationTypeId(int applicationTypeId);

}
