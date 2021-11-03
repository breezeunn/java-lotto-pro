package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	public static final String REGEX_DEFAULT_DELIMITER = ",|:";
	public static final String REGEX_CUSTOM_DELIMITER = "//(.)\\n(.*)";
	public static final String REGEX_TEXT = "\\D";

	public static int splitAndSum(String text) {
		if (isEmpty(text)) {
			return 0;
		}
		if (isCustomDelimiter(text)) {
			return customDelimiterSum(text);
		}
		return sum(split(text));
	}

	private static int customDelimiterSum(String text) {
		Matcher matcher = Pattern.compile(REGEX_CUSTOM_DELIMITER).matcher(text);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			String[] tokens = split(matcher.group(2), customDelimiter);
			return sum(tokens);
		}
		return 0;
	}

	private static boolean isCustomDelimiter(String text) {
		return text.matches(REGEX_CUSTOM_DELIMITER);
	}

	private static int sum(String[] numbers) {
		int sum = 0;
		for (String number : numbers) {
			numberValidate(number);
			sum += parseInt(number);
		}
		return sum;
	}

	private static void numberValidate(String text) {
		if (isText(text)) {
			throw new RuntimeException("문자가 포함되어 있습니다.");
		}
		if (isNegative(text)) {
			throw new RuntimeException();
		}
	}

	private static boolean isNegative(String text) {
		return Integer.parseInt(text) < 0;
	}

	private static boolean isText(String text) {
		return text.matches(REGEX_TEXT);
	}

	private static String[] split(String text) {
		return split(text, REGEX_DEFAULT_DELIMITER);
	}

	private static String[] split(String text, String delimiter) {
		return text.split(delimiter);
	}

	private static int parseInt(String text) {
		return Integer.parseInt(text);
	}

	private static boolean isEmpty(String text) {
		return text == null || text.isEmpty();
	}
}