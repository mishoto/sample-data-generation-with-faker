package dev.mihail;

import dev.mihail.config.CustomerDataGenerator;
import dev.mihail.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class SampleDataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final CustomerDataGenerator customerDataGenerator;

    public SampleDataLoader(CustomerRepository customerRepository, CustomerDataGenerator customerDataGenerator){
        this.customerRepository = customerRepository;
        this.customerDataGenerator = customerDataGenerator;

    }

    @Override
    public void run(String... args) {

        customerRepository.saveAll(customerDataGenerator.getCustomerList());
    }
}
