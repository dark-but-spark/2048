public class Clock {

    public int FPS=60;
    public int tick=1000/FPS;
    public boolean f[]=new boolean[100];
    public void refreshStart(){
        Thread thread = new Thread(() -> {refresh();});
        thread.start();
    }
    public void refresh(){
        while(true)
        {
            if(f[1]) {
            Main.userCard.refreshUserCard();
            }
            try {
                Thread.sleep(tick);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
