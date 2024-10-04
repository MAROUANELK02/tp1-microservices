package com.marouaneLK.tp1.controllers;

import com.marouaneLK.tp1.dtos.BankAccountDto;
import com.marouaneLK.tp1.services.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @GetMapping("/allAccounts")
    public List<BankAccountDto> getAllAccounts() {
        return bankAccountService.getAccounts();
    }

    @GetMapping("/account/{id}")
    public BankAccountDto getAccountById(@PathVariable long id) {
        return bankAccountService.getAccount(id);
    }

    @PostMapping("/save")
    public BankAccountDto saveAccount(@RequestBody BankAccountDto bankAccountDto) {
        return bankAccountService.saveAccount(bankAccountDto);
    }

    @PutMapping("/modify/{id}")
    public BankAccountDto modifyAccount(@PathVariable long id, @RequestBody BankAccountDto bankAccountDto) {
        return bankAccountService.updateAccount(bankAccountDto, id);
    }
}
