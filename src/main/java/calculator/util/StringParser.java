package calculator.util;

public class StringParser {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\n";

    public static String[] parse(String text) {
        if(text == null || text.isEmpty()){
            return new String[0];
        }

        String delimiter = DEFAULT_DELIMITER;
        String numbers = text;

        if (IsCustomized(text)) {
            int suffixIndex = text.indexOf(CUSTOM_DELIMITER_SUFFIX);
            delimiter = text.substring(CUSTOM_DELIMITER_PREFIX.length(), suffixIndex);
            numbers = text.substring(suffixIndex + 1);
        }

        return numbers.split(DEFAULT_DELIMITER);
    }

    private static boolean IsCustomized(String text) {
        return (text.startsWith(CUSTOM_DELIMITER_PREFIX) && text.contains(CUSTOM_DELIMITER_SUFFIX));
    }
}
