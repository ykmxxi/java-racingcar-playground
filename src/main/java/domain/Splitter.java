package domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Splitter {

	private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
	private static final String BASIC_DELIMITER_REGEX = "[,:]";

	public List<String> split(String input) {
		if (isCustomDelimiter(input)) {
			return splitByCustomDelimiter(input);
		}
		return splitByBasicDelimiter(input);
	}

	private boolean isCustomDelimiter(String input) {
		Validator validator = new Validator();
		return validator.isCustomDelimiter(input);
	}

	private List<String> splitByCustomDelimiter(String input) {
		Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
		matcher.find();

		String customDelimiter = matcher.group(1);
		return Arrays.stream(matcher.group(2).split(customDelimiter))
					 .collect(Collectors.toUnmodifiableList());
	}

	private List<String> splitByBasicDelimiter(String input) {
		return Arrays.stream(input.split(BASIC_DELIMITER_REGEX))
					 .collect(Collectors.toUnmodifiableList());

	}

}
