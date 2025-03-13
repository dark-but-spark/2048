import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class Main extends Application {
    @Override
    public void start(Stage stage) {
        System.out.println("Starting Game!");
//        BasicScene.Menu(primaryStage);
        Menu.init(stage);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
