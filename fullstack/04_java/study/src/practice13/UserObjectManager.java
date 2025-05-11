package practice13;

import java.io.*;

public class UserObjectManager {
    public static void saveUserObject(UserInfo user){
        try (FileOutputStream fos = new FileOutputStream("/Users/son-yeongho/Desktop/Work/공부/-KB-IT-s-Your-Life-6-/fullstack/04_java/study/src/practice13/userInfo.dat")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.flush();
            oos.close();

            System.out.println("✅ userInfo.dat에 사용자 정보가 저장되었습니다.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserInfo loadUserObject(){
        UserInfo user = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/son-yeongho/Desktop/Work/공부/-KB-IT-s-Your-Life-6-/fullstack/04_java/study/src/practice13/userInfo.dat"))) {
            user = (UserInfo) ois.readObject();
            System.out.println("✅ userInfo.dat에서 사용자 정보를 불러왔습니다.");
            System.out.println(user.getName() + "님의 운세 정보가 정상적으로 불러와졌습니다:");
            System.out.println(user.getFortuneSummary());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
