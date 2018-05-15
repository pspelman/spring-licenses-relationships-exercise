package com.philspelman.springlicensesrelationshipsexercise.services;

import com.philspelman.springlicensesrelationshipsexercise.models.License;
import com.philspelman.springlicensesrelationshipsexercise.models.Person;
import com.philspelman.springlicensesrelationshipsexercise.repositories.LicenseRepository;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {

    //setup connection to repository
    private LicenseRepository licenseRepository;

//    public LicenseService() {
//        System.out.println("setting totalLicenses");
//        License.totalLicenses = this.licenseRepository.findAll().size() + 1;
//    }


    public LicenseService (LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public void addNewLicense(License license) {
        System.out.println("person associated with license to be saved: " + license.getPerson());

        licenseRepository.save(license);
    }






}
