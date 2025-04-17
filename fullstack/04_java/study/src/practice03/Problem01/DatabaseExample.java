package practice03.Problem01;

public class DatabaseExample {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        Database db2 = Database.getInstance();


        db.connect();
        System.out.println("데이터베이스: " + db.connection);
        db.close();

        if (db == db2) {
            System.out.println("같아요!");
        }
    }

}
