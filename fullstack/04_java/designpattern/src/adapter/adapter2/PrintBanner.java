package adapter.adapter2;

public class PrintBanner extends Print{
    private Banner banner; // 위임 객체

    //함수를 호출할 때 같은 형태로 맞추기 위해서 아래와 같이 구성
    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen(); // 기능 위임
    }

    @Override
    public void printStrong() {
        banner.showWithAster(); // 기능 위임
    }
}
