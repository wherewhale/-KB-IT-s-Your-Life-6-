package practice03.Problem01;

class Database {
    private static Database dbInstance = new Database();

    private Database() {
    }

    public static Database getInstance() {
        return dbInstance;
    }

    String connection = "MySQL";

    public String connect() {
        System.out.println(connection + "에 연결합니다.");
        return connection;
    }

    public void close() {
        System.out.println(connection + "을 닫습니다.");
    }
}
