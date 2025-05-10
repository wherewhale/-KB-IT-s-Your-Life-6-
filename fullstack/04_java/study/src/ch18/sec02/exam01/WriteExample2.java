package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample2 {
    public static void main(String[] args) {
        try (OutputStream os = new FileOutputStream("/Users/wha1e/Documents/Develop/IT's Your Life/-KB-IT-s-Your-Life-6-/fullstack/04_java/study/src/ch18/sec02/exam01/test.txt")) {
            byte a = 10;
            byte b = 20;
            byte c = 30;
            os.write(a);
            os.write(b);
            os.write(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
