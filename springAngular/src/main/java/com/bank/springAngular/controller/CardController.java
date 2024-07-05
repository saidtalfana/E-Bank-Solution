package com.bank.springAngular.controller;

import com.bank.springAngular.model.Card;
import com.bank.springAngular.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/add_card/{id}")
    public Card registerC(@RequestBody Card card,@PathVariable int id){
        return cardService.save(card,id);
    }
    @GetMapping("/show_card")
    public List<Card> show(){
        return cardService.showCard();
    }
    @PutMapping("/update_card/{id}")
    public Card updateCard(@RequestBody Card card,@PathVariable int id){
        return cardService.save(card,id);
    }
}
