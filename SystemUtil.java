package system.util;

/**
 * Utility class for system-related functionalities.
 */
public class SystemUtil {
    private final static int NUMCOLS = 7;

    private SystemUtil() { }

    /**
     * Validates a given string.
     *
     * @param data the string to validate.
     * @return true if the string is not null, not equal to "null", and not blank; false otherwise.
     */
    public static boolean isValid(String data) {
        return data == null || data.equalsIgnoreCase("null") || data.isBlank() ? false : true;
    }

    /**
     * Parses a CSV line into an array of strings.
     *
     * @param line the CSV line to parse.
     * @return an array of strings containing the parsed values.
     */
    public static String[] lineReader(String line) {
        String[] str = new String[NUMCOLS];
        int index = 0;
        final char chComma = ',';
        final char chQuotes = '"';
        int start = 0;
        int end = line.indexOf(chComma);
        String value;
        while (start < end) {
            if (line.charAt(start) == chQuotes) {
                start++;
                end = line.indexOf(chQuotes, start + 1);
            }
            value = line.substring(start, end);
            value = value.trim();
            str[index++] = value;
            if (line.charAt(end) == chQuotes)
                start = end + 2;
            else
                start = end + 1;
            end = line.indexOf(chComma, start + 1);
        }
        if (start < line.length()) {
            value = line.substring(start);
            str[index++] = value;
        }
        return str;
    }

    /**
     * Adds quotes to a string if it contains a comma.
     *
     * @param str the string to check and possibly modify.
     * @return the modified string with quotes if needed, or the original string if not.
     */
    public static String addQuotesIfNeeded(String str) {
        if (str == null) {
            return "";
        } else if (str.contains(",")) {
            return "\"" + str + "\"";
        }
        return str;
    }
}
