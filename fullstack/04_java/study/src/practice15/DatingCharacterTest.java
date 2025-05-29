package practice15;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DatingCharacterTest {
    public static void main(String[] args) {
        List<DatingCharacter> dcList = new ArrayList<>();
        //CharacterRecommender characterRecommender = new CharacterRecommender();
        Scanner sc = new Scanner(System.in);

        DatingCharacter dc1 = DatingCharacter.builder()
                .name("지민")
                .personality("다정하고 감성적임")
                .hobby("춤")
                .favoriteFood("떡볶이")
                .talkStyle("부드럽고 공손함")
                .typeCode("S")
                .build();

        DatingCharacter dc2 = DatingCharacter.builder()
                .name("제니")
                .personality("도도하지만 배려심 있음")
                .hobby("여행")
                .favoriteFood("파스타")
                .talkStyle("털털한 반말")
                .typeCode("C")
                .build();

        DatingCharacter dc3 = DatingCharacter.builder()
                .name("태연")
                .personality("조용하지만 리더십 있음")
                .hobby("독서")
                .favoriteFood("마라탕")
                .talkStyle("시크한 느낌")
                .typeCode("T")
                .build();

        //DatingCharacter dc4 = DatingCharacter.builder()
        //        .name("수지")
        //        .personality("순수한 첫사랑 느낌")
        //        .typeCode("S")
        //        .build();
        //
        //DatingCharacter dc5 = DatingCharacter.builder()
        //        .name("민호")
        //        .personality("무뚝뚝한 츤데레")
        //        .typeCode("T")
        //        .build();

        dcList.add(dc1);
        dcList.add(dc2);
        dcList.add(dc3);
        //dcList.add(dc4);
        //dcList.add(dc5);
        Collections.sort(dcList);

        //System.out.println("[이상형 캐릭터 목록]");
        //dcList.forEach(System.out::println);

        //characterRecommender.putCharacter("다정함", dc1);
        //characterRecommender.putCharacter("도도함", dc2);
        //characterRecommender.putCharacter("조용함", dc3);
        //
        //System.out.print("""
        //        👉 어떤 성격의 캐릭터를 선호하시나요?
        //        → 다정함 / 도도함 / 조용함 중 하나를 입력해주세요.
        //        입력:\s""");
        //

        //System.out.print("""
        //        💘 어떤 유형의 캐릭터를 보고 싶나요?
        //        → S (순수형), T (츤데레형), C (차도남/차도녀형)
        //        입력:\s""");


        AtomicInteger index = new AtomicInteger(1);
        System.out.println("💘 대화하고 싶은 캐릭터를 선택하세요: ");
        dcList.forEach(datingCharacter -> System.out.println(index.getAndIncrement() + ". " + datingCharacter));
        System.out.print("번호 입력: ");

        int userInput = sc.nextInt();
        System.out.println();

        DatingCharacter result = dcList.get(userInput - 1);

        if (result.getTalkStyle().contains("반말")) System.out.println("뭐야~ 왜 이제 왔어?");
        else if (result.getTalkStyle().contains("공손")) System.out.println("오셨군요. 기다리고 있었어요.");
        else if (result.getTalkStyle().contains("시크")) System.out.println("왔네.");
        else System.out.println("안녕.");
        System.out.println();

        System.out.print("""
                👉 무엇을 말할까요?
                1. 오늘 좀 바빴어
                2. 보고 싶었어
                3. 아무 말도 하지 않는다
                선택:\s""");


        userInput = sc.nextInt();
        System.out.println();

        switch (userInput) {
            case 1:
                System.out.println("흐응~ 바빴구나. 알겠어.");
                break;
            case 2:
                System.out.println("진짜? 그 말 또 해줘 \uD83D\uDE0A");
                break;
            case 3:
                System.out.println("... (가만히 쳐다본다)");
                break;
            default:
                System.out.println("응? 무슨 말이야?");
        }


        //DatingCharacter result = characterRecommender.map.get(userInput);
        //System.out.println("[✨ 추천 결과 ✨]");
        //System.out.println("이름: " + result.getName());
        //System.out.println("성격: " + result.getPersonality());
        //System.out.println("취미: " + result.getHobby());
        //System.out.println("좋아하는 음식: " + result.getFavoriteFood());
        //System.out.println("말투 스타일: " + result.getTalkStyle());

        //System.out.println("[해당 유형 캐릭터 목록]");
        //AtomicInteger index = new AtomicInteger(1);
        //dcList.stream()
        //        .filter(datingCharacter -> datingCharacter.getTypeCode().equals(userInput))
        //        .forEach(datingCharacter -> System.out.println(index.getAndIncrement() + ". " + datingCharacter));
    }


}
