package creditcards;

import creditcards.model.CreditCard;
import org.springframework.data.repository.CrudRepository;

public interface CreditCardRepo extends CrudRepository<CreditCard, Integer> {
}
