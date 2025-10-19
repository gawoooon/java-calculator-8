package calculator.util;

public class StringParser {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";

    public static String[] parse(String text) {
        String customDelimiter = "";
        if (validateIsCustomized(text)) {
            int prefixIndex = text.indexOf(CUSTOM_DELIMITER_PREFIX);
            int suffixIndex = text.indexOf(CUSTOM_DELIMITER_SUFFIX);
            customDelimiter = text.substring(prefixIndex + 2, suffixIndex);
            String sliceText = text.substring(suffixIndex + 1);
            return sliceText.split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static boolean validateIsCustomized(String text) {
        return (text.startsWith(CUSTOM_DELIMITER_PREFIX) && text.contains(CUSTOM_DELIMITER_SUFFIX));
    }
}
