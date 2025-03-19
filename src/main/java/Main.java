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
public class Main extends Application {
    public static User user;

    public static UserCard userCard;
    public static Pane userCardRoot;

    public static Clock clock;

    public static Game game;
    public static AnchorPane gameRoot;

    public static Menu menu;

    public static Stage stage;


    @Override
    public void init() {
        System.out.println("Init game");
        user= new User(1,"admin",0,0);
        clock=new Clock();
        game=new Game();
        menu=new Menu();
    }
    @Override
    public void start(Stage primarystage) {
        stage=primarystage;
        System.out.println("Starting Game!");
//        BasicScene.Menu(primaryStage);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserCard.fxml"));
            userCardRoot = loader.load();
            userCard = loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
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
