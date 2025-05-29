package app;

import app.domain.BandPOJO;
import app.domain.MemberPOJO;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;
import java.util.List;

public class MainStep5_Save {
    public static void main(String[] args) {
        MongoCollection<BandPOJO> collection = Database.getCollection("bands", BandPOJO.class);

        MemberPOJO zero = new MemberPOJO("제로비트", "ENFP", "Vocal", 85);
        MemberPOJO mint = new MemberPOJO("민트초코", "ISTJ", "Guitar", 90);
        MemberPOJO ai = new MemberPOJO("아이시스", "ISFP", "Keyboard", 25);
        MemberPOJO dongle = new MemberPOJO("동글몽", "INTP", "Drums", 70);

        List<MemberPOJO> memberList = new ArrayList<>();
        memberList.add(zero);
        memberList.add(mint);
        memberList.add(ai);
        memberList.add(dongle);

        BandPOJO band = new BandPOJO("DreamStage", memberList);

        collection.insertOne(band);
        System.out.println("✅ 밴드 정보 저장 완료");
    }
}
