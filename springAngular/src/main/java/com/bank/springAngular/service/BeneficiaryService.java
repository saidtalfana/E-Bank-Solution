package com.bank.springAngular.service;

import com.bank.springAngular.model.Beneficiary;
import com.bank.springAngular.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryService {
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    public Beneficiary save(Beneficiary beneficiary){
        return beneficiaryRepository.save(beneficiary);
    }
    public List<Beneficiary> allBeneficiaries(){
    return beneficiaryRepository.findAll();
    }

}
