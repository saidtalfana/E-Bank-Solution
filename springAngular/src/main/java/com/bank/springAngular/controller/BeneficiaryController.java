package com.bank.springAngular.controller;

import com.bank.springAngular.model.Beneficiary;
import com.bank.springAngular.service.BeneficiaryService;
import com.bank.springAngular.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController {
    @Autowired
    private BeneficiaryService beneficiaryService;
}