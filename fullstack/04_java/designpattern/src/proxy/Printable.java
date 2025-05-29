package proxy;

//Spring 초창기 버전에서 썼던 기법
// 위임을 위한 인터페이스
public interface Printable {
    void setPrinterName(String name); // 이름 설정
    String getPrinterName(); // 이름 취득
    void print(String string); // 문자열 표시(프린트 아웃)
}
