package creditcards.validators;

import java.util.stream.IntStream;

public class LuhnUtil {

    public static boolean test(String card){

        int[] numbers = card.chars()
                .map(LuhnUtil::ConvertASCIIToNumer).toArray();
        boolean isValid =
                IntStream.range(0,numbers.length)
                        .map (i -> (((i%2) ^ (numbers.length%2)) == 0) ? ((2*numbers[i])/10+(2*numbers[i])%10) : numbers[i])
                        .sum() % 10 == 0;
        return isValid;
    }

    private static int ConvertASCIIToNumer(int value) {
        return Character.digit(value, 10);
    }
}
