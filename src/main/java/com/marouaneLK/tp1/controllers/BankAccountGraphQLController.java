package com.marouaneLK.tp1.controllers;

import com.marouaneLK.tp1.dtos.BankAccountDto;
import com.marouaneLK.tp1.services.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class BankAccountGraphQLController {
    private final BankAccountService bankAccountService;

    @QueryMapping
    public List<BankAccountDto> accounts() {
        return bankAccountService.getAccounts();
    }

    @QueryMapping
    public BankAccountDto accountById(@Argument long id) {
        return bankAccountService.getAccount(id);
    }

    @MutationMapping
    public BankAccountDto createAccount(@Argument BankAccountDto account) {
        return bankAccountService.saveAccount(account);
    }

    @MutationMapping
    public BankAccountDto updateAccount(@Argument BankAccountDto account, @Argument long id) {
        return bankAccountService.updateAccount(account, id);
    }

    @MutationMapping
    public String deleteAccount(@Argument long id) {
        return bankAccountService.deleteAccount(id);
    }

}
