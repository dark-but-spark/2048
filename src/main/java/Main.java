import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class Main extends Application {
    public static User user;
    public static UserCard userCard;
    public static Pane userCardRoot;
    public static Clock clock;
    @Override
    public void init() {
        System.out.println("Init game");
        user= new User(1,"admin",0,0);
        clock=new Clock();
    }
    @Override
    public void start(Stage stage) {
        System.out.println("Starting Game!");
//        BasicScene.Menu(primaryStage);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserCard.fxml"));
            userCardRoot = loader.load();
            userCard = loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
        }
        clock.f[1]=true;
        clock.refreshStart();
        Menu.initMenu(stage);
    }
    @Override
    public void stop() {
        System.out.println("Stop game!");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
