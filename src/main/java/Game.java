import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Game {
    // This is a class that represents the game
    @FXML
    private Label Cell00,Cell01,Cell02,Cell03,
            Cell10,Cell11,Cell12,Cell13,
            Cell20,Cell21,Cell22,Cell23,
            Cell30,Cell31,Cell32,Cell33;


    private Label[][] Cells;
    private int[][] CellsValue;
    //This is a method that initializes the game
    public Game()
    {
        ;
    }
    public void initGame(){
        System.out.println("Game is starting!");
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Game.fxml"));
            AnchorPane gameRoot=loader.load();
            Main.game=loader.getController();
            Scene scene=new Scene(gameRoot,720,569);
            Main.stage.setScene(scene);
        }catch(Exception e) {
            e.printStackTrace();
        }
        Cells=new Label[4][4];
        CellsValue=new int[4][4];
        Cells[0][0]=this.Cell00;Cells[0][1]=this.Cell01;Cells[0][2]=this.Cell02;Cells[0][3]=this.Cell03;
        Cells[1][0]=this.Cell10;Cells[1][1]=this.Cell11;Cells[1][2]=this.Cell12;Cells[1][3]=this.Cell13;
        Cells[2][0]=this.Cell20;Cells[2][1]=this.Cell21;Cells[2][2]=this.Cell22;Cells[2][3]=this.Cell23;
        Cells[3][0]=this.Cell30;Cells[3][1]=this.Cell31;Cells[3][2]=this.Cell32;Cells[3][3]=this.Cell33;

        System.out.println("Label set complete!");

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                CellsValue[i][j]=(i+1)*10+j+1;
                Cells[i][j].setText(Integer.toString(CellsValue[i][j]));
            }
        }
        System.out.println("Value set complete!");
        Main.clock.f[2]=1;

        Main.stage.setTitle("Game");
        Main.stage.show();
    }

    //This is a method that random place the basic elements
    public void randomPlace(){

    }

    //This is a method that refresh the game
    public void refreshGame()
    {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Cells[i][j].setText(Integer.toString(CellsValue[i][j]));
            }
        }

    }

    //This is a method that check if the game is over
    public void gameOver(){

    }

    //This is a method that update the score
    public void updateScore(){

    }

    //This is a method that move the elements
    public void move(){

    }
}
