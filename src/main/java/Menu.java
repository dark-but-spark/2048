import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javax.swing.*;

public class Menu {
    @FXML
    private static AnchorPane background;
    @FXML
    private static Button start;
    @FXML
    private void startAction(){
        System.out.println("Game started!");

    }
    @FXML
    private void exitAction(){
        System.out.println("Good bye!");
        System.exit(0);
    }
    public static void init(Stage stage) {
        System.out.println("Menu initialized!");
        FXMLLoader loader = new FXMLLoader(Menu.class.getResource("Menu.fxml"));
        try {
            AnchorPane root = loader.load();
            Scene scene = new Scene(root, 720, 569);
            stage.setTitle("2048");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
