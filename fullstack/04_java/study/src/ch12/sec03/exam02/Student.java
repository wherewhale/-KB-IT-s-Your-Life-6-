package ch12.sec03.exam02;

public class Student {
    private int no;
    private String name;

    //멤버 필드 초기화
    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    // getter
    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }


    //setter
    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 3. equals() 메서드 재정의
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student target) {
            if (no == target.getNo() && name.equals(target.getName())) {
                return true;
            }
        }
        return false;
    }

    // 4. hashCode() 재정의
    @Override
    public int hashCode() {
        int hashCode = no + name.hashCode();
        return hashCode;
    }

    // 5. toString() 재정의
    @Override
    public String toString() {
        return "Student{no=" + no + ", name='" + name + "'}";
    }
}
