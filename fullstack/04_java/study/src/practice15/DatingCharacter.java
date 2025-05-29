package practice15;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DatingCharacter implements Comparable<DatingCharacter>, CharacterType {
    private String name; //연예인 이름 (예: 지민, 제니)
    private String personality; //성격 묘사 (예: 다정한, 도도한 등)
    private String hobby; //취미 (예: 춤, 독서, 여행 등)
    private String favoriteFood; //좋아하는 음식
    private String talkStyle; //대화 스타일 (예: 애교, 단호 등)
    private String typeCode; //캐릭터 유형 코드 ("S", "T", "C")

    @Override
    public int compareTo(DatingCharacter datingCharacter) {
        return name.compareTo(datingCharacter.name);
    }

    @Override
    public String toString() {
        //이름: 제니 / 성격: 도도하지만 배려심 있음 / 취미: 여행
        //return String.format("이름: %s / 성격: %s / 취미: %s", name, personality, hobby);
        return String.format("이름: %s / 성격: %s / 유형 : %s", name, personality, typeCode);
    }


    public static class Builder {
        private String name;
        private String email;
        private String password;
        private String phone;
        private String address;
        private boolean sex;
        private int age;

        private Builder() {

        } // private 생성자이므로 외부에서 생성 불가

        public Builder name(String name) {
            this.name = name;
            return this;
        }
    }
}


