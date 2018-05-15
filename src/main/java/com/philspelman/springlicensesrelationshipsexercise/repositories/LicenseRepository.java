package com.philspelman.springlicensesrelationshipsexercise.repositories;

import com.philspelman.springlicensesrelationshipsexercise.models.License;
import com.philspelman.springlicensesrelationshipsexercise.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LicenseRepository extends CrudRepository<License, Long> {

    List<License> findAll();

    License findLicenseByPerson(Person person);

    

}
