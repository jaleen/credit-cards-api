package creditcards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import creditcards.model.CreditCard;
import creditcards.service.CreditCardService;

import java.util.List;

@RestController
public class CreditCardsController {

    @Autowired
    CreditCardService service;

    @GetMapping("/credit-cards")
    public Iterable<CreditCard> getCreditCards() {

        return service.getAllCards();
    }


    @PostMapping("/credit-cards")
    @ResponseStatus (HttpStatus.CREATED)
    public void createCreditCard(CreditCard card) {

        service.createCreditCard(card);
    }
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid request")
    void onIllegalArgumentException(IllegalArgumentException exception) {}
}
