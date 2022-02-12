package com.houseapplication.microservice.houseapplications.dao;

import com.houseapplication.microservice.houseapplications.entity.HouseApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseApplicationRepository extends CrudRepository<HouseApplication, Integer> {
    List<HouseApplication> findByApplicationTypeId(int applicationTypeId);

}
