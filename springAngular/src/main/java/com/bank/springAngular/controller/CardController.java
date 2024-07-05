package com.bank.springAngular.controller;

import com.bank.springAngular.model.Card;
import com.bank.springAngular.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/add_card")
    public Card registerC(@RequestBody Card card){
        return cardService.save(card);
    }
}
