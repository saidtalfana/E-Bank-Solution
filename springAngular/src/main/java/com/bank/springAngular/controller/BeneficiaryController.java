package com.bank.springAngular.controller;

import com.bank.springAngular.model.Beneficiary;
import com.bank.springAngular.service.BeneficiaryService;
import com.bank.springAngular.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/beneficiary")
public class BeneficiaryController {
    @Autowired
    private BeneficiaryService beneficiaryService;



    @PostMapping("/add_beneficiary")
    public Beneficiary register(@RequestBody Beneficiary beneficiary){
        return beneficiaryService.save(beneficiary);
    }
    @GetMapping("/all_beneficiary")
    public List<Beneficiary> allBeneficiary(){
        return beneficiaryService.allBeneficiaries();
    }
}
