package calculator;

public class Number {

    private final int number;

    Number(int number) {
        this.ensureZeroOrPositiveNumber(number);
        this.number = number;
    }

    Number(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new RuntimeException("Input is not a number.");
        }

        this.ensureZeroOrPositiveNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private void ensureZeroOrPositiveNumber(int num) {
        if (num < 0) {
            throw new RuntimeException("Input is not a positive number.");
        }
    }
}
