import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class BasicScene {//简单的小测试 但是所有元素堆在一起 开始尝试使用fxml
    public static void Menu(Stage primaryStage){
        Label label = new Label("Hello, 2048!");
        Button startButton= new Button("Start Game");
        startButton.setOnAction(e -> {
            // Code to start the game goes here
            initGame(primaryStage);
        });
        StackPane root = new StackPane();
        root.getChildren().addAll(label,startButton);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("2048");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void initGame(Stage primaryStage) {
        System.out.println("Game started!");
        Label label= new Label("Game successfully started!");
        Button gameOverButton= new Button("Game Over");
        gameOverButton.setOnAction(e->{
            Gameover(primaryStage);
        });
        StackPane root = new StackPane();
        root.getChildren().addAll(label,gameOverButton);
        Scene scene = new Scene(root,800,600);
        primaryStage.setTitle("2048");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void Gameover(Stage primaryStage) {
        System.out.println("Game Over!");
        Label label= new Label("Game Over!");
        Button startButton= new Button("Restart Game");
        Button returnToMenuButton= new Button("Return to Menu");
        Button ExitButton= new Button("Exit");
        startButton.setOnAction(e->{
            initGame(primaryStage);
        });
        returnToMenuButton.setOnAction(e->{
            Menu(primaryStage);
        });
        ExitButton.setOnAction(e->{
            System.exit(0);
        });
        StackPane root = new StackPane();
        root.getChildren().addAll(label,startButton,returnToMenuButton,ExitButton);
        Scene scene = new Scene(root,800,600);
        primaryStage.setTitle("Game over");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
