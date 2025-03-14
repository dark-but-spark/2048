import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application {
    public static User user;
    public static UserCard userCard;
    @Override
    public void init() {
        System.out.println("Init game");
    }
    @Override
    public void start(Stage stage) {
        System.out.println("Starting Game!");
//        BasicScene.Menu(primaryStage);
        user= new User(1,"admin",0,0);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserCard.fxml"));
            VBox userCardRoot = loader.load();
            Main.userCard = loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
