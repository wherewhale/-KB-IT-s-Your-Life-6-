package practice16;

public class SmoothSkinFilter implements FilterStrategy {
    //문자열을 모두 소문자로 변환한 뒤, 마지막에 "✨"를 붙이세요.
    @Override
    public String apply(String input) {
        return input.toLowerCase() + "✨";
    }
}
