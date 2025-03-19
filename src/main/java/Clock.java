import javafx.application.Platform;

public class Clock {

    public int FPS=60;
    public int tick=1000/FPS;
    public int f[]=new int[100];
    public void refreshStart(){
        Thread thread = new Thread(() -> {refresh();});
        thread.start();
    }
    public void refresh(){
        while(true)
        {
            if(f[1]==1) {
                Platform.runLater(() -> Main.userCard.refreshUserCard());
            }
            if(f[2]==1)
            {
                Platform.runLater(() -> Main.game.refreshGame());
            }
            try {
                Thread.sleep(tick);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
