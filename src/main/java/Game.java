import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game {
    // This is a class that represents the game
    @FXML
    private Label Cell00,Cell01,Cell02,Cell03,
            Cell10,Cell11,Cell12,Cell13,
            Cell20,Cell21,Cell22,Cell23,
            Cell30,Cell31,Cell32,Cell33;
    @FXML
    private Label Score,MaxScore;
    @FXML
    private Pane GameOverPane;
    @FXML
    private Pane MoreButton;

    private Label[][] Cells;
    private int[][] CellsValue;
    //This is a method that initializes the game
    public Game()
    {
    }
    @FXML
    private void showButton(){
        Thread thread = new Thread(() -> {
            MoreButton.setVisible(true);
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            MoreButton.setVisible(false);


        });
        thread.start();
    }
    @FXML
    private void keyAction(KeyEvent event)
    {
        KeyCode keyCode = event.getCode();
//        System.out.println("Key Pressed: " + keyCode.getName());
        if(keyCode==KeyCode.UP)
        {
//            System.out.println("UP");
            Main.game.move(1);
        }
        else if(keyCode==KeyCode.DOWN)
        {
//            System.out.println("DOWN");
            Main.game.move(2);
        }
        else if(keyCode==KeyCode.LEFT)
        {
//            System.out.println("LEFT");
            Main.game.move(3);
        }
        else if(keyCode==KeyCode.RIGHT)
        {
//            System.out.println("RIGHT");
            Main.game.move(4);
        }
        else if(keyCode==KeyCode.ESCAPE)
        {
            System.out.println("Return to menu!");
            Main.clock.f[2]=0;
            Main.clock.f[1]=1;
            Main.menu.initMenu();
        }
    }

    @FXML
    private void returnMenu(){
        System.out.println("Return to menu!");
        Main.clock.f[2]=0;
        Main.clock.f[1]=1;
        Main.menu.initMenu();
    }
    @FXML
    private void exitGame()
    {
        System.out.println("Good bye!");
        System.exit(0);
    }
    @FXML
    public void restartGame(){
        System.out.println("Game is restarting!");
        GameOverPane.setVisible(false);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                CellsValue[i][j]=0;
            }
        }
        this.randomPlace();this.randomPlace();
        Main.user.score=0;
        Main.user.times++;
    }
    public void initGame(){
        System.out.println("Game is starting!");
        GameOverPane.setVisible(false);
        Cells=new Label[4][4];
        CellsValue=new int[4][4];
        Cells[0][0]=Cell00;Cells[0][1]=Cell01;Cells[0][2]=Cell02;Cells[0][3]=Cell03;
        Cells[1][0]=Cell10;Cells[1][1]=Cell11;Cells[1][2]=Cell12;Cells[1][3]=Cell13;
        Cells[2][0]=Cell20;Cells[2][1]=Cell21;Cells[2][2]=Cell22;Cells[2][3]=Cell23;
        Cells[3][0]=Cell30;Cells[3][1]=Cell31;Cells[3][2]=Cell32;Cells[3][3]=Cell33;

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                CellsValue[i][j]=0;
            }
        }
        this.randomPlace();this.randomPlace();
        Main.user.score=0;
        Main.user.times++;

        Main.clock.f[2]=1;
        Scene scene=new Scene(Main.gameRoot,720,569);

        Main.stage.setScene(scene);
        Main.stage.setTitle("Game");
        Main.stage.show();
    }

    //This is a method that random place the basic elements
    public void randomPlace(){
        int x=(int)(Math.random()*4);
        int y=(int)(Math.random()*4);
        int a=Math.random()>0.6?4:2;
        while(CellsValue[x][y]!=0){
            x=(int)(Math.random()*4);
            y=(int)(Math.random()*4);
        }
        CellsValue[x][y]=a;
    }

    //This is a method that refresh the game
    public void refreshGame()
    {
        Score.setText("Score: "+Main.user.score);
        MaxScore.setText("MaxScore: "+Main.user.maxScore);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(CellsValue[i][j]!=0) {
                    Cells[i][j].setText(Integer.toString(CellsValue[i][j]));
                    Cells[i][j].setStyle("-fx-background-color:" + Color.Cell(CellsValue[i][j]));
                }
                else{
                    Cells[i][j].setText("");
                    Cells[i][j].setStyle("-fx-background-color:#CDC1B4");
                }
            }
        }
    }

    //This is a method that check if the game is over
    public boolean gameOver(){
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(CellsValue[i][j]==0)
                {
                    return false;
                }
                if((j+1<4&&CellsValue[i][j]==CellsValue[i][j+1])
                        ||(i+1<4&&CellsValue[i][j]==CellsValue[i+1][j]))
                {
                    return false;
                }
            }
        }
        return true;

    }

    //This is a method that update the score
    public void updateScore(int x){
        Main.user.score+=x;
        if(Main.user.score>Main.user.maxScore)
        {
            Main.user.maxScore=Main.user.score;
        }
    }
    int[] newValue;
    //This is a method that move the elements
    public void move(int id) {//1:up 2:down 3:left 4:right
        int f_change = 0;

        if (id == 1 || id == 2) {
            for (int j = 0; j < 4; j++) {
                int[] column = new int[4];
                for (int i = 0; i < 4; i++) {
                    column[i] = CellsValue[i][j];
                }
                transform(column, id == 1);
                for (int i = 0; i < 4; i++) {
                    if (newValue[i] != CellsValue[i][j]) {
                        f_change = 1;
                    }
                    CellsValue[i][j] = newValue[i];

                }
                newValue = null;
            }
        } else if (id == 3 || id == 4) {
            for (int i = 0; i < 4; i++) {
                int[] row = new int[4];
                for (int j = 0; j < 4; j++) {
                    row[j] = CellsValue[i][j];
                }
                transform(row, id == 3);
                for (int j = 0; j < 4; j++) {
                    if (newValue[j] != CellsValue[i][j]) {
                        f_change = 1;
                    }
                    CellsValue[i][j] = newValue[j];
                }
                newValue = null;
            }
        }
        if (f_change == 1) {
            this.randomPlace();
        }
        if (gameOver())
        {
            GameOverPane.setVisible(true);
        }
    }

    //This is a method that transform the elements
    public void transform(int[] column, boolean id){
        newValue=new int[4];
        int k=0;
        for(int i=0;i<4;i++)
        {
            if(column[i]!=0)
            {
                newValue[k++]=column[i];
            }
        }
        if(!id)
        {
            for(int i=0;i*2<k;i++)
            {
                int t=newValue[i];
                newValue[i]=newValue[k-i-1];
                newValue[k-i-1]=t;
            }

        }
        for(int i=0;i<k-1;i++)
        {
            if(newValue[i]==newValue[i+1])
            {
                newValue[i]*=2;
                updateScore(newValue[i]);
                for(int j=i+1;j<k-1;j++)
                {
                    newValue[j]=newValue[j+1];
                }
                newValue[k-1]=0;
            }
        }
        while(k<4)
        {
            newValue[k++]=0;
        }
        if(!id)
        {
            for(int i=0;i*2<k;i++)
            {
                int t=newValue[i];
                newValue[i]=newValue[k-i-1];
                newValue[k-i-1]=t;
            }

        }
    }
}
