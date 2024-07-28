package stringStudy.calculator;
public class PositiveNumber {
    private final int value;

    public PositiveNumber(String value) {
        int intValue = parseAndValidate(value);
        this.value = intValue;
    }

    private int parseAndValidate(String value) {
        int intValue;

        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값은 전달 못한다.");
        }
        if (isNegativeNumber(intValue)) {
            throw new IllegalArgumentException("0 또는 음수를 전달할 수 없습니다.");
        }

        return intValue;
    }

    private boolean isNegativeNumber(int value) {
        return value <= 0;
    }

    public int toInt() {
        return value;
    }

}