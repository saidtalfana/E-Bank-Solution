package com.bank.springAngular.service;

import com.bank.springAngular.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiaryService {
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;
}