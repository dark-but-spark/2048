import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.security.KeyStore;

public class UserCard {
    public int cnt = 0xFFFFFF;
    public User user;

    public UserCard() {
        this.user = new User(-1, "guest", 0, 0);
    }

    //用户信息的显示------------------------------------
    @FXML
    private VBox userInfo;
    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label rankLabel;
    public void refreshUserCard() {//刷新用户卡片 clock调用
        user.rank = (int) (user.maxScore * 0.01 + user.times * 0.5);
//        System.out.println("User card refreshed!");
        try {
//            System.out.printf("%d %s %d\n",user.id,user.name,user.rank);
            this.idLabel.setText("ID:" + Integer.toString(user.id));
            this.nameLabel.setText("Name:" + user.name);
            this.rankLabel.setText(Integer.toString(user.rank));
//            String color = String.format("-fx-background-color:#%06XA0;", cnt);
            this.rankLabel.setStyle("-fx-background-color:" + Color.Cell(user.rank));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //登录注册的按钮------------------------------------
    @FXML
    private HBox loginHbox;

    //登录部分-------------------------------------
    @FXML
    private VBox loginCard;
    @FXML
    private TextField loginName;
    @FXML
    private PasswordField loginPWD;

    @FXML
    private void initLoginMenu() {
        userInfo.setVisible(false);
        loginHbox.setVisible(false);
        loginCard.setVisible(true);
    }

    @FXML
    private void loginSubmit() {
        String name = loginName.getText();
        String pwd = loginPWD.getText();
        if (Main.dataBase.login(name, pwd)) {
            user = Main.dataBase.getUser(name);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Login failed!");
            alert.setContentText("Please check your name and password!");
            alert.showAndWait();
        }
        userInfo.setVisible(true);
        loginHbox.setVisible(true);
        loginCard.setVisible(false);
    }

    //注册部分-------------------------------------
    @FXML
    private VBox registerCard;
    @FXML
    private TextField registerName;
    @FXML
    private PasswordField registerPWD;
    @FXML
    private PasswordField registerPWD2;

    @FXML
    private void initRegisterMenu() {

        userInfo.setVisible(false);
        loginHbox.setVisible(false);
        registerCard.setVisible(true);
    }

    @FXML
    private void registerSubmit() {
        String name = registerName.getText();
        String pwd = registerPWD.getText();
        String pwd2 = registerPWD2.getText();
        if (pwd.equals(pwd2)) {
            Main.dataBase.register(name, pwd);
            user = Main.dataBase.getUser(name);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Register failed!");
            alert.setContentText("Please check your password!");
            alert.showAndWait();
        }
        userInfo.setVisible(true);
        loginHbox.setVisible(true);
        registerCard.setVisible(false);
    }


    //    @FXML
//    public int id,rank;
//    @FXML
//    public  String name;
//    public void initUserCard(){
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserCard.fxml"));
//            VBox userCardRoot = loader.load();
//            Main.userCard = loader.getController();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
