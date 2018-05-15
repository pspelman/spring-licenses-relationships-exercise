package com.philspelman.springlicensesrelationshipsexercise.controllers;

import com.philspelman.springlicensesrelationshipsexercise.models.License;
import com.philspelman.springlicensesrelationshipsexercise.models.Person;
import com.philspelman.springlicensesrelationshipsexercise.services.LicenseService;
import com.philspelman.springlicensesrelationshipsexercise.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PersonController {

    //done: hook up the service
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @RequestMapping("/")

    public String index(Model model) {
        System.out.println("LicenseController: reached the index");

        return "index";

    }

    @RequestMapping("/persons/new")
    public String createPerson(@ModelAttribute("person") Person person) {
        System.out.println("LicenseController: Getting form to add new person");

        return "personFormNew";
    }

    @PostMapping("/persons/new")
    public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("Errors in person data");
            return "personFormNew";
        } else {
            System.out.println("data good, saving new person");
            this.personService.addPerson(person);
            return "redirect:/persons/all";
        }
    }




    @RequestMapping("/persons/all")
    public String showAllPersons(Model model) {
        System.out.println("gettign all persons");
        List<Person> persons = personService.allPersons();

        model.addAttribute("persons", persons);

        return "allPersons";
    }



    @RequestMapping("/licenses/new")
    public String addLicenseForm(@ModelAttribute("license") License license,
                                 Model model) {

        List<Person> persons = personService.allPersons();
        //DONE: get all persons (to populate the dropdown

        model.addAttribute("persons", persons);
        //this populates the persons dropdown

        //DONE: if the person HAS a license, then it needs to be UPDATED, not replaced - maybe do this in the service for now

        return "licenseFormNew";

    }

    //DONE: add a method to save a new license to the DB
    @PostMapping("/licenses/new")
    public String createLicense(@Valid @ModelAttribute("license") License license,
                                @ModelAttribute("person") Person person,
                                BindingResult bindingResult) {


        System.out.println("trying to add license for person: " + license.getPerson());
        System.out.println("new license data: " + license);

        //check for errors
        if (bindingResult.hasErrors()) {
            System.out.println("Errors in data!");
            return "licenseFormNew";
        } else {
            System.out.println("no errors, now attempting to save new license to DB");
            personService.addNewLicense(license);
//            personService.addNewLicense(person, license);
            return "redirect:/persons/all";
        }

    }

    @RequestMapping("/persons/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        System.out.println("trying to delete person w/ID: " + id);
        personService.destroyPerson(id);

        return "redirect:/persons/all";

    }


}
