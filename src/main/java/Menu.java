import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javax.swing.*;

public class Menu {
    public Menu(){
        ;
    }
    @FXML
    private void startAction(){//开始游戏
        System.out.println("Game started!");
        Main.clock.f[1]=0;
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Game.fxml"));
            Main.gameRoot=loader.load();
            Main.game=loader.getController();

        }catch(Exception e) {
            e.printStackTrace();
        }
        Main.game.initGame();


    }
    @FXML
    private void exitAction(){//退出游戏
        Main.dataBase.update(Main.userCard.user);
        System.out.println("Good bye!");
        System.exit(0);
    }



    public void initMenu() {//初始化菜单
        System.out.println("Menu initialized!");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            AnchorPane menuRoot = loader.load();
            menuRoot.getChildren().add(Main.userCardRoot);//将用户卡片加入菜单 采用add方法
            Scene scene = new Scene(menuRoot, 720, 569);
            Main.stage.setTitle("2048");
            Main.stage.setScene(scene);
            Main.stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
