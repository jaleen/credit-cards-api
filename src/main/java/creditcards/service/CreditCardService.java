package creditcards.service;

import creditcards.CreditCardRepo;
import creditcards.model.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
    CreditCardRepo repo;

    @Autowired (required = true)
    public CreditCardService(CreditCardRepo repo){
        this.repo=repo;
    }
    public CreditCard createCreditCard(CreditCard card) {
        return repo.save(card);
    }

    public Iterable<CreditCard> getAllCards() {
        return repo.findAll();
    }
}
