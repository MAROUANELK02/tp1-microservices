package com.marouaneLK.tp1.controllers;

import com.marouaneLK.tp1.dtos.BankAccountDto;
import com.marouaneLK.tp1.entities.BankAccount;
import com.marouaneLK.tp1.mappers.BankAccountMapper;
import com.marouaneLK.tp1.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class BankAccountGraphQLController {
    private final BankAccountRepository accountRepository;
    private final BankAccountMapper bankAccountMapper;

    @QueryMapping
    public List<BankAccount> accounts() {
        return accountRepository.findAll();
    }

    @QueryMapping
    public BankAccount accountById(@Argument long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public BankAccountDto createAccount(@Argument BankAccountDto account) {
        BankAccount bankAccount = bankAccountMapper.toBankAccount(account);
        bankAccount.setId(null);
        bankAccount.setCreatedAt(new Date());
        return bankAccountMapper.toBankAccountDto(accountRepository.save(bankAccount));
    }
}
