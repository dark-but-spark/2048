import javafx.application.Platform;

public class Clock {

    public int FPS=60;//每秒刷新频率
    public int tick=1000/FPS;//每次刷新的时间间隔
    public int f[]=new int[100];//刷新任务的列表
    //f[1] UserCard刷新
    //f[2] Game刷新


    public void refreshStart(){
        Thread thread = new Thread(() -> {refresh();});//建立刷新线程
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
