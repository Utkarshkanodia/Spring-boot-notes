package com.notes.jpa.cardinalities.one_to_one.bidirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component("client_bidirectional_one_to_one")
public class OneToOneBidirectionalClient {

    AadhaarRepository aadhaarRepository;
    PersonRepository personRepository;

    @Autowired
    OneToOneBidirectionalClient(AadhaarRepository aadhaarRepository, PersonRepository personRepository) {
        this.aadhaarRepository = aadhaarRepository;
        this.personRepository = personRepository;
    }

    public void save() {
        Random random = new Random();
        String[] firstNames = new String[]{"John", "Jane", "Jack", "Bob"};
        String[] lastNames = new String[]{"Doe", "Smith", "Jones", "Snow"};
        for (int i = 0; i < 4; i++) {
            int randomNumber = random.nextInt(1_00_00_000) + 1;
            Person person = new Person();
            person.setFirstName(firstNames[i]);
            person.setLastName(lastNames[i]);

            Aadhaar aadhaar = new Aadhaar();
            aadhaar.setAdhaarNumber(Integer.toString(randomNumber) + "#" + i);
            aadhaar.setVid(Integer.toString((randomNumber % 3) + 93749) + "!" + i);

            person.setAadhaar(aadhaar);
            aadhaar.setPerson(person);

            personRepository.save(person);
        }
    }


    public List<Aadhaar> getAllAadhar() {
        return aadhaarRepository.findAll();
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
