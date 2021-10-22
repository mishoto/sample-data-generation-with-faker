package dev.mihail;

import com.github.javafaker.Faker;
import dev.mihail.model.Address;
import dev.mihail.model.Customer;
import dev.mihail.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final Faker faker;

    public SampleDataLoader(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {

        List<Customer> customers = IntStream.rangeClosed(1,100)
                .mapToObj(i -> new Customer(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().phoneNumber(),
                        faker.internet().emailAddress(),
                        new Address(
                                faker.address().country(),
                                faker.address().city(),
                                faker.address().streetName(),
                                faker.address().streetAddressNumber(),
                                faker.address().state()
                        )
                )).collect(Collectors.toUnmodifiableList());

        customerRepository.saveAll(customers);

    }
}
