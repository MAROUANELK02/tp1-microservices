package com.marouaneLK.tp1.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marouaneLK.tp1.dtos.BankAccountDto;
import com.marouaneLK.tp1.entities.BankAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BankAccountMapper {
    private final ObjectMapper objectMapper;

    public BankAccount toBankAccount(BankAccountDto bankAccountDto) {
        return objectMapper.convertValue(bankAccountDto, BankAccount.class);
    }

    public BankAccountDto toBankAccountDto(BankAccount bankAccount) {
        return objectMapper.convertValue(bankAccount, BankAccountDto.class);
    }

    public List<BankAccountDto> toBankAccountDtoList(List<BankAccount> bankAccounts) {
        List<BankAccountDto> bankAccountDtoList = new ArrayList<>();
        for (BankAccount bankAccount : bankAccounts) {
            bankAccountDtoList.add(toBankAccountDto(bankAccount));
        }
        return bankAccountDtoList;
    }

}
