import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class UserCard {
    public int cnt=0xFFFFFF;
    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label rankLabel;
    public void refreshUserCard()
    {
//        System.out.println("User card refreshed!");
        try{
//            System.out.printf("%d %s %d\n",Main.user.id,Main.user.name,Main.user.rank);
            Main.userCard.idLabel.setText("ID:"+Integer.toString(Main.user.id));
            Main.userCard.nameLabel.setText("Name:"+Main.user.name);
            Main.userCard.rankLabel.setText("Rank:"+Integer.toString(Main.user.rank));
            String color=String.format("-fx-background-color:#%06XA0;",cnt);
//            System.out.println(color);
//            cnt--;
            Main.userCard.rankLabel.setStyle(color);
//            id=Main.user.id;
//            name=Main.user.name;
//            rank=Main.user.rank;
        } catch(Exception e){
            e.printStackTrace();
        }

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
