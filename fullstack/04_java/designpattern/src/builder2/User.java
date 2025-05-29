package builder2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private boolean sex;
    private int age;

    public User() {
    }

    //외부에서는 사용할 수 없는 private 생성자 (중요)
    private User(String name, String email, String password, String phone, String address, boolean sex, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.sex = sex;
        this.age = age;
    }

    //Builder도 외부에서 생성을 못하도록 제한
    public static class Builder {
        private String name;
        private String email;
        private String password;
        private String phone;
        private String address;
        private boolean sex;
        private int age;

        private Builder() {
        } //private 생성자이므로 외부에서 생성 불가

        //return 타입이 Builder인 이유는 메서드 체이닝을 사용하기 위함
        //Builder 뒤에 .Builder .Builder 와 같은 형식으로 사용하기 위해서
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder sex(boolean sex) {
            this.sex = sex;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        //return 타입은 User이고, private 메소드에 대한 권한이 있기 때문에, 실행 가능
        public User build() {
            return new User(name, email, password, phone, address, sex, age);
        }
    }

    //여기서 Builder 또한 private이므로, 외부에서 직접 실행이 불가
    //따라서, 새로운 Builder를 만들어주는 public static Builder 메소드를 만들어줌
    //이걸 실행시키기 위해서는 Builder b = user.builder(); 와 같은 형식으로 호출
    public static Builder builder() {
        return new Builder(); // private 생성자 호출
    }
}

