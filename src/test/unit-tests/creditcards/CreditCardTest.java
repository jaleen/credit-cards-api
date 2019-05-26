package creditcards;
import creditcards.model.CreditCard;
import creditcards.service.CreditCardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CreditCardTest {


    @MockBean
    private CreditCardRepo repo;
    @Autowired
    private CreditCardService service;
    @Test
    public void whenACardIsSaved_thenItIsCreatedSuccessfully(){


        CreditCard card = CreditCard.builder().cardNo("1111-2222-3333-4444").name("Jalal ul deen").build();
        when(repo.save(card)).thenReturn(card);
        CreditCard actualCard = service.createCreditCard(card);

        assertThat(actualCard, is(equalTo(card)));

    }
}



