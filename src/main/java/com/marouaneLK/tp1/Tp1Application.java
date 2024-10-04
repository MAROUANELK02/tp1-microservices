package com.marouaneLK.tp1;

import com.marouaneLK.tp1.entities.BankAccount;
import com.marouaneLK.tp1.enums.AccountType;
import com.marouaneLK.tp1.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Tp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp1Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository) {
		return args -> {
				bankAccountRepository.save(BankAccount.builder()
								.balance(2000.00)
								.createdAt(new Date())
								.currency("MAD")
								.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
						.build());
			bankAccountRepository.save(BankAccount.builder()
					.balance(8000.00)
					.createdAt(new Date())
					.currency("MAD")
					.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
					.build());
			bankAccountRepository.save(BankAccount.builder()
					.balance(500.00)
					.createdAt(new Date())
					.currency("MAD")
					.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
					.build());
		};
	}

}
