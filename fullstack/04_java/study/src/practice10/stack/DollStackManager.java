package practice10.stack;

import practice10.util.RandomDollProvider;

import java.util.Stack;

public class DollStackManager {
    Stack<String> dollBox = new Stack<String>();

    public String storeRandomDoll() {
        String newDoll = RandomDollProvider.getRandomDoll();
        dollBox.push(newDoll);
        System.out.println("🧸 " + newDoll + "인형이 보관함에 추가되었습니다.");
        return newDoll;
    }

    public void showStack() {
        System.out.print("🧸 현재 보관 중인 인형 : ");
        System.out.print(dollBox);
        System.out.println();
    }
}
