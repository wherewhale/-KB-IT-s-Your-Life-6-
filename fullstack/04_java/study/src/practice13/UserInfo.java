package practice13;

import lombok.Setter;

import java.io.Serializable;

@Setter
public class UserInfo implements Serializable {
    private String name;
    private String birth;
    private String fortuneSummary; // 분석 요약 결과

    public UserInfo(String name, String birth) {
        this.name = name;
        this.birth = birth;
    }

    public UserInfo(String name, String birth, String fortuneSummary) {
        this.name = name;
        this.birth = birth;
        this.fortuneSummary = fortuneSummary;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getFortuneSummary() {
        return fortuneSummary;
    }

    @Override
    public String toString() {
        return "이름: " + name + "\n생년월일: " + birth + "\n분석 요약 결과: " + fortuneSummary;
    }
}
