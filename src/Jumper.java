
/* @author marbi */
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.List;

public class Jumper implements Comparable<Jumper> {
    
    private String name;
    private int jumpLength;
    private int[] judgesvotes;
    private int totalScore;
    private List<Integer> jumps;
    
    public Jumper(String name) {
        this.name = name;
        this.jumpLength = 0;
        this.judgesvotes = new int[5];
        this.totalScore = 0;
        jumps = new ArrayList<Integer>();
    }
    
    public String getName() {
        return name;
    }
    
    public void setjumpLenght() {
        Random rand = new Random();
        
        this.jumpLength = rand.nextInt(120 - 60) + 60;
        jumps.add(this.jumpLength);
    }
    
    public void setjudgesVotes() {
        Random rand = new Random();
        
        for (int i = 0; i < 5; i++) {
            this.judgesvotes[i] = rand.nextInt(20 - 10) + 10;
        }
    }
    
    public int subTotal() {
        int jVotes = 0;
        
        Arrays.sort(judgesvotes);
        for (int i = 1; i < 4; i++) {
            jVotes += this.judgesvotes[i];
        }
        
        return this.jumpLength + jVotes;
    }
    
    public void setTotalScore(int total) {
        
        this.totalScore += total;
    }
    
    public int getTotalScore() {
        return this.totalScore;
    }
    
    public int getjumpLength() {
        return this.jumpLength;
    }
    
    public void getVotes() {
        for (int vote : judgesvotes) {
            System.out.println(vote);
        }
    }
    
    public void getJumps() {
        String output = "";
        
        for (int jump : jumps) {
            output += jump + " m, ";
        }
        
        output = output.substring(0, output.length() - 2);

        System.out.println("            jump lengths: " + output);
    }
    
    @Override
    public String toString() {
        return "  " + this.name + '\n' + "    length: " + this.jumpLength + '\n' + "    judge votes: " + Arrays.toString(this.judgesvotes);
    }
    
    @Override
    public int compareTo(Jumper o) {
        if (this.totalScore == o.totalScore) {
            return 0;
        } else {
            return this.totalScore > o.totalScore ? 1 : -1;
        }
    }
    
}
