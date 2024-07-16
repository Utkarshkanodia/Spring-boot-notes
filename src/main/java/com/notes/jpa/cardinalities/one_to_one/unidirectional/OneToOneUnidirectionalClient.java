package com.notes.jpa.cardinalities.one_to_one.unidirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("client_unidirectional_one_to_one")
public class OneToOneUnidirectionalClient {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    CustomerRepository customerRepository;

    public void save() {
        Customer customer = new Customer();
        customer.setType(CustomerType.ULTRA_PREMIUM);

        Profile profile = new Profile();
        profile.setFirstName("utkarsh");
        profile.setLastName("kanodia");

        customer.setProfile(profile);
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteProfile(long id) {
        profileRepository.deleteById(id);
    }

    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }



}
