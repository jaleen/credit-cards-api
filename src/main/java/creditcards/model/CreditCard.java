package creditcards.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer cardId;
    private String name;
    private String cardNo;
    private int cardLimit;
}
