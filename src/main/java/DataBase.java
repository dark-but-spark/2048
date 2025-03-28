import java.sql.*;
import java.util.Random;
import java.security.MessageDigest;
import java.util.Base64;

public class DataBase {       //此类还在施工中^_^ 下次再来看吧

    Connection connection = null;
    Statement statement = null;

    public DataBase() {
        try {
            Class.forName("org.sqlite.JDBC");

            // 创建数据库连接
            connection = DriverManager.getConnection("jdbc:sqlite:/path/to/your/database.db");

            // 创建Statement对象
            statement = connection.createStatement();

            // 创建表
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "name TEXT UNIQUE NOT NULL," +
                    "pwd TEXT NOT NULL," +
                    "maxScore INTEGER NOT NULL" +
                    "times INTEGER NOT NULL)";
            statement.executeUpdate(createTableSQL);

            // 插入数据
            String insertSQL = "INSERT INTO users (name, age) VALUES ('John', 25)";
            statement.executeUpdate(insertSQL);

            System.out.println("数据插入成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean login(String username, String password) {
        return true;
    }

    public User getUser(String username) {
        Random random = new Random();
        return new User(random.nextInt(10), username, random.nextInt(2048), random.nextInt(50));
    }

    public void register(String name, String password) {
        ;
    }

    public static String hash(String input) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(input.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes); // 将字节数组转换为 Base64 字符串
    }
}