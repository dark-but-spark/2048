import java.sql.*;
import java.security.MessageDigest;
import java.util.Base64;

public class DataBase {       //此类还在施工中^_^ 下次再来看吧

    Connection connection = null;
    Statement statement = null;
    //初始化数据库
    public DataBase() {
        try {
            Class.forName("org.sqlite.JDBC");

            // 创建数据库连接
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/2048.db");

            // 创建Statement对象
            statement = connection.createStatement();

            // 创建表
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "name TEXT UNIQUE NOT NULL," +
                    "pwd TEXT NOT NULL," +
                    "maxScore INTEGER NOT NULL," +
                    "times INTEGER NOT NULL)";

            statement.executeUpdate(createTableSQL);
            System.out.println("Table Created!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //登录验证
    public boolean login(String username, String password)  {
        try {
            String selectSQL = "SELECT * FROM users WHERE name = '" + username + "'";
            ResultSet resultSet = statement.executeQuery(selectSQL);
            if (resultSet.next()) {
                String pwd = resultSet.getString("pwd");
                if (pwd.equals(hash(password))) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //注册验证
    public void register(String name, String password) throws Exception
    {
        String checkSQL = "SELECT * FROM users WHERE name = '"+name+"'";
        ResultSet resultSet = statement.executeQuery(checkSQL);
        if (resultSet.next()) {
            throw new Exception("用户名已存在");
        }
        String insertSQL = "INSERT INTO users (name,pwd,maxScore,times) VALUES ('"+name+"', '"+hash(password)+"',0,0)";
        statement.executeUpdate(insertSQL);
        System.out.println("数据插入成功！");
    }
    //获取用户信息
    public User getUser(String username) {
        try {
            String selectSQL = "SELECT * FROM users WHERE name = '" + username + "'";
            ResultSet resultSet = statement.executeQuery(selectSQL);
            if (resultSet.next()) {
                return new User(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("maxScore"),
                        resultSet.getInt("times"));
            } else {
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //更新用户信息
    public void update(User user) {
        try {
            String updateSQL = "UPDATE users SET maxScore = " + user.maxScore + ", times = " + user.times + " WHERE id = " + user.id;
            statement.executeUpdate(updateSQL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //密码加密
    public static String hash(String input) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(input.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes); // 将字节数组转换为 Base64 字符串
    }
}