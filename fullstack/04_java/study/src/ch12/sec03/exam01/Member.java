package ch12.sec03.exam01;

public class Member {
    public String id;

    public void Memeber(String id) {
        this.id = id;
    }

    //cmd + n으로 자동 생성 가능
    //@Override
    //public boolean equals(Object o) {
    //    if (!(o instanceof Member member)) return false;
    //    return Objects.equals(id, member.id);
    //}
    //
    //@Override
    //public int hashCode() {
    //    return Objects.hashCode(id);
    //}

    //@Override
    //public boolean equals(Object obj) {
    //    if(obj instanceof Member target) { // 타입 감사
    //        if(id.equals(target.id)) { // id 문자열이 같은지 비교
    //            return true;
    //        }
    //    }
    //    return false;
    //}
}
