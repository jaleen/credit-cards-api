package creditcards.validators;

import lombok.Data;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(Theories.class)
public class LuhnUtilTest {


    @DataPoints
    public static LuhnTestData[] cards() {
        return new LuhnTestData[]{
                new LuhnTestData("4532075816253398", true),
                new LuhnTestData("348957109769986", true),
                new LuhnTestData("6382766559733887", true),
                new LuhnTestData("49927398716", true),
                new LuhnTestData("1234567812345670", true),
                new LuhnTestData("4111111111111111", true),
                new LuhnTestData("5893189066521295", true),
                new LuhnTestData("4111111111111112", false),
                new LuhnTestData("49927398717", false),
                new LuhnTestData("1234567812345678", false)

        };
    }


    @Theory
    public void whenValidTestCards_thenShouldReturnTrue(LuhnTestData cards) {
        assertThat(LuhnUtil.test(cards.cardNo)).isEqualTo(cards.result);

    }


    @Data
    public static class LuhnTestData {
        private String cardNo;
        private boolean result;

        public LuhnTestData(String cardNo, boolean result) {

            this.cardNo = cardNo;
            this.result = result;
        }
    }

}
