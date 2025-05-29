package composite;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    //Entry를 넣었기 때문에, File, Directory 모두 가능
    private List<Entry> directory = new ArrayList<>();
    public Directory(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        //Directory인 경우 재귀호출을 통해서 size를 종합
        int size = 0;
        //자신의 하위 엔트리를 확인하여 사이즈 합계
        for (Entry entry : directory) {
            size += entry.getSize();
        }
        return size;
    }
    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        //리스트를 출력할 때, 디렉토리인 경우에 재귀 호출
        for(Entry entry: directory) {
            entry.printList(prefix + "/" + name);
        }
    }
    // 디렉터리 엔트리를 디렉터리에 추가한다.
    //add는 그릇 역할을 담당한다고 볼 수 있음
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}
