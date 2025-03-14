import java.util.Scanner;
public class User {
    public String name;
    public int id;
    public int maxScore;
    public int score;
    public int times;
    public int rank;
    public User(int id, String name, int maxScore,int times) {
        this.id = id;
        this.name = name;
        this.maxScore = maxScore;
        this.score = 0;
        this.times=times;
        this.rank=(int)(this.maxScore*0.01+this.times*0.5)+1;
    }
}
