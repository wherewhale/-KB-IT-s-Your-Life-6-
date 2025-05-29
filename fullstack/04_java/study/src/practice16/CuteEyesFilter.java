package practice16;

public class CuteEyesFilter implements FilterStrategy {
    public static String EYE_REGEX = "[aeiouAEIOU]";

    @Override
    public String apply(String input) {
        return input.replaceAll(EYE_REGEX, "\uD83D\uDC41");
    }
}
