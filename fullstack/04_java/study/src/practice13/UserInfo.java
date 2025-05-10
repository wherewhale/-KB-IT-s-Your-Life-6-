package practice13;

public class UserInfo {
    private String name;
    private String birth;

    public UserInfo(String name, String birth) {
        this.name = name;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return "이름: " + name + "\n생년월일: " + birth;
    }
}
