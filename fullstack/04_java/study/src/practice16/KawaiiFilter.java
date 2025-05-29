package practice16;

public class KawaiiFilter implements FilterStrategy {

    @Override
    public String apply(String input) {
        StringBuffer sb = new StringBuffer(input);
        String reverse = sb.reverse().toString();

        return reverse + "\uD83C\uDF38";
    }
}
