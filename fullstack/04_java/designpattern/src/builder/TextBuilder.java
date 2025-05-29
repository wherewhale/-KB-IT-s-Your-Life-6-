package builder;

public class TextBuilder extends Builder {
    private StringBuilder sb = new StringBuilder();
    @Override
    public void makeTitle(String title) {
        sb.append("=========================\n");
        sb.append("[");
        sb.append(title);
        sb.append("]\n\n");
    }
    @Override
    public void makeString(String str) {
        sb.append("■");
        sb.append(str);
        sb.append("\n\n");
    }

    @Override
    public void makeItems(String[] items) {
        for(String s: items) {
            sb.append(".");
            sb.append(s);
            sb.append("\n");
        }
        sb.append("\n");
    }
    @Override
    public void close() {
        sb.append("=========================\n");
    }

    @Override
    public void getResult() {

    }

    //추상 메소드 구현
    public String getTextResult() {
        return sb.toString(); //복잡한 인스턴스
    }
}
