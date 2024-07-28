package stringStudy.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int add(String input) {

        String delimiter = ",|:";
        String numbers = input;

        Matcher customDelimiterMatcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (customDelimiterMatcher.matches()) {
            delimiter = Pattern.quote(customDelimiterMatcher.group(1));
            numbers = customDelimiterMatcher.group(2);
        }

        String[] numberSplit = numbers.split(delimiter);

        return Arrays.stream(numbers.split(delimiter))
                .map(PositiveNumber::new)
                .mapToInt(PositiveNumber::toInt)
                .sum();
    }
}
