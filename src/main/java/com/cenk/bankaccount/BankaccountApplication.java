package com.cenk.bankaccount;

import com.cenk.bankaccount.model.Customer;
import com.cenk.bankaccount.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class BankaccountApplication implements CommandLineRunner {

	private final CustomerRepository customerRepository;

	public BankaccountApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BankaccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		customerRepository.save(new Customer("" , "kullanici1" , "kullanici1Soyad"));

	}
}
