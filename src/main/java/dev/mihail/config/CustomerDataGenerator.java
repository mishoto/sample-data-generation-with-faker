package dev.mihail.config;


import com.github.javafaker.Faker;
import dev.mihail.model.Address;
import dev.mihail.model.Customer;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
public class CustomerDataGenerator extends Faker{

    private static final int START_RANGE_GENERATION = 1;
    private static final int END_RANGE_GENERATION = 20;
    private final List<Customer> customerList;

    public CustomerDataGenerator(){

        this.customerList = setCustomerList();
    }

    List<Customer> setCustomerList() {
        List<Customer> customers = IntStream.rangeClosed(START_RANGE_GENERATION,END_RANGE_GENERATION)
                .mapToObj(i -> generateCustomer()).collect(Collectors.toList());
        return customers;
    }

    public List<Customer> getCustomerList(){
        return this.customerList;
    }


    Customer generateCustomer() {
        return new Customer(
                name().firstName(),
                name().lastName(),
                phoneNumber().phoneNumber(),
                internet().emailAddress(),
                generateAddress()
        );
    }

   Address generateAddress() {
       return new Address(
               address().country(),
               address().city(),
               address().streetName(),
               address().streetAddressNumber(),
               address().state()
       );
    }
}
