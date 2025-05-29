package practice01;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class Band extends BandComponent {
    private String name;
    private List<BandComponent> members = new ArrayList<>();

    public Band(String name) {
        this.name = name;
    }

    public void add(BandComponent component) {
        members.add(component);
    }

    public String getName() {
        return name;
    }

    public List<Member> getMembers() {
        List<Member> result = new ArrayList<>();
        for(BandComponent member: members) {
            if(member instanceof Member) result.add((Member) member);
            else {
                Band band = (Band) member;
                result.addAll(band.getMembers());
            }
        }
        return result;
    }

    @Override
    public void perform() {
        System.out.println("💡 무대 조명 ON");
        System.out.println("🎉 관객: 와아아아아!!!!");
        System.out.println("🎤 밴드 [" + name + "] 공연을 시작합니다!");

        for(BandComponent member: members) {
            member.perform();
        }

        System.out.println("🎤 밴드 [" + name + "] 공연 종료!");
        System.out.println("🔌 무대 조명 OFF");
        System.out.println();
    }

    public void printStructure(String prefix) {
        if(prefix.isEmpty()) {
            System.out.printf("|- \uD83C\uDFA4 Band - %s\n", name);
        } else {
            System.out.println("|- " + prefix + "🎤 Band - " + name);
        }

        for(BandComponent member: members) {
            member.printStructure(prefix + "  ");
        }
    }
}
