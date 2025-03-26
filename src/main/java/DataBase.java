import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class DataBase {

    public boolean login(String username, String password)
    {
        return true;
    }
    public User getUser(String username)
    {
        Random random = new Random();
        return new User(random.nextInt(10),username,random.nextInt(2048),random.nextInt(50));
    }
    public void register(String name,String password)
    {
        ;
    }
    public void creattest() {
        ;
    }
}