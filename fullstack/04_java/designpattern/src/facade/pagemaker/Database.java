package facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database() {}

    // 데이터베이스 이름에서 Properties를 얻는다.
    public static Properties getProperties(String dbname) throws IOException {
        // dbname.txt 파일을 읽어서 Properties 객체를 생성한다.
        // static getProperties 메서드를 호출하여, DB 정보를 읽어온다.
        Properties prop = new Properties();
        prop.load(new FileInputStream(dbname + ".txt"));
        return prop;
    }
}
