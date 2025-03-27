import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static java.lang.System.exit;

public class Main extends Application {

    public static User user;

    public static UserCard userCard; //用户卡片 同时内部有User类管理User信息
    public static Pane userCardRoot; //UserCard页面的根指针

    public static Clock clock; //刷新时钟

    public static Game game; //2048游戏的控制类
    public static AnchorPane gameRoot;//game页面的根指针

    public static Menu menu;//menu页面

    public static Stage stage;//整体舞台

    public static DataBase dataBase;//数据库类 连接数据库（目前选择sqlite）


    @Override
    public void init() {//初始化方法
        System.out.println("Init game");
        user= new User(-1,"guest",0,0);
        clock=new Clock();
        game=new Game();
        menu=new Menu();
        dataBase=new DataBase();
    }
    @Override
    public void start(Stage primarystage) {//创建UserCard控制器且其根目录 开启刷新线程 初始化目录
        stage=primarystage;
        System.out.println("Starting Game!");
//        BasicScene.Menu(primaryStage);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserCard.fxml"));
            userCardRoot = loader.load();
            userCard = loader.getController();
            userCard.user=user;
        } catch (Exception e) {
            e.printStackTrace();
            exit(0);
        }

        clock.f[1]=1;
        clock.refreshStart();
        menu.initMenu();

    }
    @Override
    public void stop() {
        System.out.println("Stop game!");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
