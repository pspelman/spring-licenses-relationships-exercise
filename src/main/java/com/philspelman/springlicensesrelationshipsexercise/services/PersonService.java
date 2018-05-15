package com.philspelman.springlicensesrelationshipsexercise.services;

import com.philspelman.springlicensesrelationshipsexercise.models.License;
import com.philspelman.springlicensesrelationshipsexercise.models.Person;
import com.philspelman.springlicensesrelationshipsexercise.repositories.LicenseRepository;
import com.philspelman.springlicensesrelationshipsexercise.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    //DONE: initialize my repository
    private PersonRepository personRepository;
    private LicenseRepository licenseRepository;



    public PersonService(PersonRepository personRepository, LicenseRepository licenseRepository) {
        this.personRepository = personRepository;
        this.licenseRepository = licenseRepository;
        License.totalLicenses = licenseRepository.findAll().size();

//
//        personRepository.deleteAll();
//        licenseRepository.deleteAll();

        if (this.personRepository.findAll().size() < 1) {
            System.out.println("Nothing in the repo...adding saple person");
            this.addNewPersons();

        }
    }

    private void addNewPersons() {
        this.personRepository.save(new Person("Phil", "Spelman"));
        this.personRepository.save(new Person("John", "Johnnman"));
        this.personRepository.save(new Person("Sarah", "Bonnie"));
    }

    public List<Person> allPersons() {
        System.out.println("Trying to get all persons");
        return personRepository.findAll();
    }

    //DONE: activate the repository here

    public void addPerson(Person person) {
        System.out.println("adding new person");

        this.personRepository.save(person);
    }


    public void addNewLicense(License license) {

        License licenseResult = licenseRepository.findLicenseByPerson(license.getPerson());

        System.out.println("license found? " + licenseResult );
        if (licenseResult != null) {
            System.out.println("they already have a license...deleting previous entry");
            System.out.println("id: " + licenseResult.getId());


            // overwrite the existing license by taking the ID and the license number I generated
            license.setId(licenseResult.getId());
            license.setNumber(licenseResult.getNumber());


            licenseRepository.save(license);

//            licenseRepository.deleteById(licenseResult.getId());

        } else {
            System.out.println("New license, proceed");
            this.licenseRepository.save(license);
        }

//
//        System.out.println("new total licenses: " + License.totalLicenses);
//
//        System.out.println("trying to add license for: " + license.getPerson());
//        License.totalLicenses = licenseRepository.findAll().size();
//        System.out.println("new license repo size: " + licenseRepository.findAll().size());

    }


    public void destroyPerson(Long id) {
        System.out.println("PersonService: trying to delete person w/id: " + id);
        this.personRepository.deleteById(id);

    }
}
