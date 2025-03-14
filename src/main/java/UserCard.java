import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class UserCard {
    @FXML
    private Button idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label rankLabel;
    public void refreshUserCard()
    {
        System.out.println("User card refreshed!");
        try{
            System.out.printf("%d %s %d\n",Main.user.id,Main.user.name,Main.user.rank);
            Main.userCard.idLabel.setText(Integer.toString(Main.user.id));
            Main.userCard.nameLabel.setText(Main.user.name);
            Main.userCard.rankLabel.setText(Integer.toString(Main.user.rank));
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
