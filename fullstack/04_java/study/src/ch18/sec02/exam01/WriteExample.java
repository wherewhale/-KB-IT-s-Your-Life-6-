package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        // 입출력은 예외 처리를 신경써주어야 한다.
        try {
            OutputStream os =
                    new FileOutputStream("C:/temp/test1.db");

            byte a = 10;
            byte b = 20;
            byte c = 30;

            os.write(a);
            os.write(b);
            os.write(c);

            os.flush(); //버퍼가 다 차지 않았기 때문에, 직접 flush (3 Bytes만 씀)
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
